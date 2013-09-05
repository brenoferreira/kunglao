package controllers

import play.api.mvc.{Action, Controller}
import models.{Player, User}
import infrastructure.{SlickDatabaseFactory, GameParser}
import play.libs.Akka
import akka.actor.Props
import actors.ScoreActor

/**
 * Created with IntelliJ IDEA.
 * User: Breno
 * Date: 04/09/13
 * Time: 14:39
 * To change this template use File | Settings | File Templates.
 */
object GameController extends Controller {
  val db = SlickDatabaseFactory.create

  def index = Action {
    Ok(views.html.game.render("Welcome kombatant!"))
  }

  def create = Action { request =>
    val parsedScore = request.body.asJson.map { json =>
      GameParser(json)
    }

    parsedScore map { score =>
      val actor = Akka.system actorOf Props(new ScoreActor(db))

      actor ! score
    }

    Status(201)
  }
}
