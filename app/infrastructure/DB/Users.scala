package infrastructure.DB

/**
 * Created with IntelliJ IDEA.
 * User: Breno
 * Date: 03/09/13
 * Time: 14:19
 * To change this template use File | Settings | File Templates.
 */

import scala.slick.driver.H2Driver.simple._

object Users extends Table[(Int, String, String, String)]("User") {
  def id = column[Int]("id", O.PrimaryKey)
  def name = column[String]("name")
  def username = column[String]("username")
  def email = column[String]("email")

  def * = id ~ name ~ username ~ email
}
