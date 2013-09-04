import infrastructure.GameParser
import models.Player
import org.specs2.mutable._
import play.api.libs.json.Json
/**
 * Created with IntelliJ IDEA.
 * User: Breno
 * Date: 04/09/13
 * Time: 18:16
 * To change this template use File | Settings | File Templates.
 */
class GameParserTests extends Specification {
  "GameParser" should {
    "parse json to game score" in {
      val json = Json parse "{\"winner\":\"teste1\",\"loser\":\"teste2\",\"by\":2,\"to\":0}"

      val score = GameParser(json)

      score.winner must be_==(Player("teste1"))
      score.loser must be_==(Player("teste2"))
      score.winnerScore must beEqualTo(2)
      score.loserScore must beEqualTo(0)
    }
  }
}
