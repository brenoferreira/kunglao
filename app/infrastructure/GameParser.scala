package infrastructure

import play.api.libs.json.JsValue
import models.Player

/**
 * Created with IntelliJ IDEA.
 * User: Breno
 * Date: 04/09/13
 * Time: 18:10
 * To change this template use File | Settings | File Templates.
 */
object GameParser {
  def apply(json:JsValue) = {
      val winner = Player((json \ "winner").as[String])
      val loser = Player((json \ "loser").as[String])
      val winnerScore = (json \ "by").as[Int]
      val loserScore = (json \ "to").as[Int]

      winner winsOver loser by winnerScore to loserScore
  }
}
