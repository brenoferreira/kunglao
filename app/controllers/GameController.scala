package controllers

import play.api.mvc.{Action, Controller}
import models.{Player, User}
import infrastructure.GameParser

/**
 * Created with IntelliJ IDEA.
 * User: Breno
 * Date: 04/09/13
 * Time: 14:39
 * To change this template use File | Settings | File Templates.
 */
object GameController extends Controller {
  def index = Action {
    Ok(views.html.game.render("Welcome kombatant!"))
  }

  def create = Action { request =>
    val score = request.body.asJson.map { json =>
      GameParser(json)
    }

    Status(201)
  }
}
