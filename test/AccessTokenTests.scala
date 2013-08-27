/**
 * Created with IntelliJ IDEA.
 * User: Breno
 * Date: 27/08/13
 * Time: 11:02
 * To change this template use File | Settings | File Templates.
 */

import infrastructure._

import org.specs2.mutable._
class AccessTokenTests extends Specification {
  "AccessToken" should {
    "parse token from facebook" in {
      val tokenFromFacebook = "access_token=CAACWPaYWnBQBAPo7afARigxMIc0uOA4XI4vSnEdCOsgH5dwgnfaB0YZCwlYQ1hnCJN2YXZCyUkjJ36BDzIX5vt0LqIKRfBwyIYyO7CD67I6R2IcwD9wbTcqMiebj8K01esV9CqET2oZCg9J9BCcyYNEsVoIOVyTkm8orHbiUw48oVZCc2E6u&expires=5165690"

      val token = AccessToken(tokenFromFacebook)
      token.token must beEqualTo("CAACWPaYWnBQBAPo7afARigxMIc0uOA4XI4vSnEdCOsgH5dwgnfaB0YZCwlYQ1hnCJN2YXZCyUkjJ36BDzIX5vt0LqIKRfBwyIYyO7CD67I6R2IcwD9wbTcqMiebj8K01esV9CqET2oZCg9J9BCcyYNEsVoIOVyTkm8orHbiUw48oVZCc2E6u")
    }
  }
}
