package controllers

import play.api.mvc.{Action, Controller}
import models.{Player, User}
import infrastructure.{SlickDatabaseFactory, GameParser}
import play.libs.Akka
import play.api.libs.json.Json
import akka.actor.Props
import actors.ScoreActor
import scala.concurrent.Future
import infrastructure.DB.Users
import scala.slick.driver.H2Driver.simple._

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

  def players = Action {
    db withSession { implicit session:Session =>
      val users = Query(Users)
        .list
        .map(user =>
              Map(
                "id" -> Json.toJson(user._1),
                "name" -> Json.toJson(user._2)
              )
        )

      Ok(Json.toJson(users.toSeq))
    }
  }
}
