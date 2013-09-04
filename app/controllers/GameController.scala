package controllers

import play.api.mvc.{Action, Controller}

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
}
