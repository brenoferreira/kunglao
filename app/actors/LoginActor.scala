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

class LoginActor extends Actor  {
  def receive = {
    case User(id, name, userName) =>
  }
}
