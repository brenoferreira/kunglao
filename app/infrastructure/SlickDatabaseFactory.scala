package infrastructure

import scala.slick.session.Database
import play.api.Play

/**
 * Created with IntelliJ IDEA.
 * User: Breno
 * Date: 05/09/13
 * Time: 11:36
 * To change this template use File | Settings | File Templates.
 */
object SlickDatabaseFactory {
  def create = {
    Database.forURL(
      Play.current.configuration.getString("db.default.url").get,
      Play.current.configuration.getString("db.default.user").get,
      Play.current.configuration.getString("db.default.password").get,
      null,
      Play.current.configuration.getString("db.default.driver").get
    )
  }
}
