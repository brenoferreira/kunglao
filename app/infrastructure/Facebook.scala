package infrastructure

/**
 * Created with IntelliJ IDEA.
 * User: Breno
 * Date: 27/08/13
 * Time: 10:51
 * To change this template use File | Settings | File Templates.
 */
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

