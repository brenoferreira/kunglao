package infrastructure.DB

/**
 * Created with IntelliJ IDEA.
 * User: Breno
 * Date: 03/09/13
 * Time: 14:19
 * To change this template use File | Settings | File Templates.
 */

import scala.slick.driver.H2Driver.simple._

object Users extends Table[(String, String, String, String)]("USER") {
  def id = column[String]("ID", O.PrimaryKey)
  def name = column[String]("NAME")
  def username = column[String]("USERNAME")
  def email = column[String]("EMAIL")

  def * = id ~ name ~ username ~ email
}
