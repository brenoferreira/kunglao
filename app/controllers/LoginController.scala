package controllers

import play.api.mvc.{Action, Controller}
import infrastructure.{FacebookConfig, AccessToken, FacebookLogin}
import play.libs.Akka
import akka.actor.Props
import actors.LoginActor
import scala.slick.session.Database
import play.api.Play

/**
 * Created with IntelliJ IDEA.
 * User: Breno
 * Date: 26/08/13
 * Time: 11:43
 * To change this template use File | Settings | File Templates.
 */

import dispatch._, Defaults._

object LoginController extends Controller {

  val db = Database.forURL(
    Play.current.configuration.getString("db.default.url").get,
    Play.current.configuration.getString("db.default.user").get,
    Play.current.configuration.getString("db.default.password").get,
    null,
    Play.current.configuration.getString("db.default.driver").get)

  def login = Action {
    val url = String.format(
      FacebookConfig.facebookRedirectBaseUrl,
      FacebookConfig.appId,
      FacebookConfig.redirectUrl)

    Redirect(url)
  }

  def auth(code:Option[String]) = Action {
    def createRequest(code:String) = {
      val uri = String.format(
        FacebookConfig.getAccessTokenUrl,
        FacebookConfig.appId,
        FacebookConfig.redirectUrl,
        FacebookConfig.appSecret,
        code)
      val svc = url(uri)

      Http(svc OK as.String)
    }

    Async {
      val accessTokenFuture = for (
        request <- createRequest(code.get)
      ) yield AccessToken(request)

      accessTokenFuture.map(accessToken => {
        val facebookLogin = new FacebookLogin(accessToken)

        val user = facebookLogin.getUserInfo

        val actor = Akka.system().actorOf(Props(new LoginActor(db)))

        actor ! user

        Redirect(routes.GameController.index).withSession("username" -> user.username)
      })
    }
  }
}
