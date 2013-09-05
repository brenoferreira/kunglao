package infrastructure.DB

import scala.slick.driver.H2Driver.simple._

/**
 * Created with IntelliJ IDEA.
 * User: Breno
 * Date: 05/09/13
 * Time: 11:14
 * To change this template use File | Settings | File Templates.
 */
object Scores extends Table[(Option[Int], String, String, Int, Int)]("SCORE") {
  def id = column[Int]("ID", O.PrimaryKey, O.AutoInc)
  def winner = column[String]("WINNER")
  def loser = column[String]("LOSER")
  def winnerScore = column[Int]("WINNERSCORE")
  def loserScore = column[Int]("LOSERSCORE")


  def * = id.? ~ winner ~ loser ~ winnerScore ~ loserScore
}
