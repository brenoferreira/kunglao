package infrastructure

import com.restfb.DefaultFacebookClient
import com.restfb.types.User

/**
 * Created with IntelliJ IDEA.
 * User: Breno
 * Date: 27/08/13
 * Time: 10:51
 * To change this template use File | Settings | File Templates.
 */

object FacebookConfig {
  def facebookRedirectBaseUrl = "https://www.facebook.com/dialog/oauth?client_id=%s&redirect_uri=%s"
  def getAccessTokenUrl = "https://graph.facebook.com/oauth/access_token?client_id=%s&redirect_uri=%s&client_secret=%s&code=%s"
  def appId = "165191523671060"
  def redirectUrl = "http://localhost:9000/login/auth"
  def appSecret = "9dc03399972fb53f6632d2199cb588bc"
}

class AccessToken(val token:String)

object AccessToken{
  val regex = """access_token=(\w+)&expires=\d+""".r

  def apply(accessTokenResult:String) = {
    regex findFirstIn accessTokenResult match {
      case Some(regex(token)) => new AccessToken(token)
      case None => null
    }
  }
}

class FacebookLogin(val accessToken:AccessToken) {
  val fbClient = new DefaultFacebookClient(accessToken.token)

  def getUserInfo = {
    val user = fbClient.fetchObject("me", classOf[User])
    new models.User(user.getId, user.getName, user.getUsername)
  }
}