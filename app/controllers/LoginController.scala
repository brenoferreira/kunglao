package controllers

import play.api.mvc.{Action, Controller}

/**
 * Created with IntelliJ IDEA.
 * User: Breno
 * Date: 26/08/13
 * Time: 11:43
 * To change this template use File | Settings | File Templates.
 */

import dispatch._, Defaults._

object LoginController extends Controller {
  val facebookRedirectBaseUrl = "https://www.facebook.com/dialog/oauth?client_id=%s&redirect_uri=%s"
  val getAccessTokenUrl = "https://graph.facebook.com/oauth/access_token?client_id=%s&redirect_uri=%s&client_secret=%s&code=%s"
  val appId = "165191523671060"
  val redirectUrl = "http://localhost:9000/login/auth"
  val appSecret = "9dc03399972fb53f6632d2199cb588bc"

  def login = Action {
    val url = String.format(facebookRedirectBaseUrl, appId, redirectUrl)
    Redirect(url)
  }

  def auth(code:Option[String]) = Action {
    def createRequest(code:String) = {
      val uri = String.format(getAccessTokenUrl, appId, redirectUrl, appSecret, code)
      val svc = url(uri)

      Http(svc OK as.String)
    }

    Async {

      for (
        request <- createRequest(code.get)
      ) yield Ok(request)
    }
  }
}
