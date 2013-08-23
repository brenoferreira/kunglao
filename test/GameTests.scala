/**
 * Created with IntelliJ IDEA.
 * User: Breno
 * Date: 23/08/13
 * Time: 16:11
 * To change this template use File | Settings | File Templates.
 */
import org.specs2.mutable._
import models._

class GameTests extends Specification {
  "Game" should {
    "specify victory" in {
      val breno = Player("breno")
      val john = Player("john")
      val res = breno winsOver john by 2 to 1

      res.winner must be(breno)
      res.winnerScore must beEqualTo(2)
      res.loser must be(john)
      res.loserScore must beEqualTo(1)
    }
    "specify victory by 2 to 0 by default" in {
      val breno = Player("breno")
      val john = Player("john")
      val res = breno winsOver john by 2

      res.winner must be(breno)
      res.winnerScore must beEqualTo(2)
      res.loser must be(john)
      res.loserScore must beEqualTo(0)
    }

    "cant win by a score larger than 2" in {
      val breno = Player("breno")
      val john = Player("john")
      val res = breno winsOver john by 3 must throwA[Exception]
    }
  }

}
