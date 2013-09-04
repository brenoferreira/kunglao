package actors

/**
 * Created with IntelliJ IDEA.
 * User: Breno
 * Date: 03/09/13
 * Time: 14:11
 * To change this template use File | Settings | File Templates.
 */

import akka.actor.Actor
import models.User
import infrastructure.DB.Users
import scala.slick.driver.H2Driver.simple._
import scala.slick.session.{ Database, Session }

class LoginActor(val db:Database) extends Actor  {
  def receive = {
    case User(id, name, username) => {

      db withSession { implicit session:Session =>
        Users.insert(id, name, username, "")
      }
    }
  }
}
