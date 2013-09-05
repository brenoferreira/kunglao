package actors

import akka.actor.Actor
import models.Score
import scala.slick.driver.H2Driver.simple._
import scala.slick.session.{Session, Database}
import infrastructure.DB.Scores

/**
 * Created with IntelliJ IDEA.
 * User: Breno
 * Date: 05/09/13
 * Time: 11:06
 * To change this template use File | Settings | File Templates.
 */
class ScoreActor(val db:Database) extends Actor {
  def receive = {
    case Score(winner, winnerScore, loser, loserScore) =>
      db withSession { implicit session:Session =>
        Scores.insert(None, winner.name, loser.name, winnerScore, loserScore)
      }
  }
}
