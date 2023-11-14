package functional

import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import play.api.test.FakeRequest
import play.api.test.Helpers.{GET,contentAsString, defaultAwaitTimeout, route, writeableOf_AnyContentAsEmpty}

class UserServiceFunctionalSpec extends PlaySpec with GuiceOneAppPerSuite {



  "AsyncVisitorController" should{

   "return find and create of user" in{
     contentAsString(route(app, FakeRequest(GET, "/users")).get) mustBe "0"

   }
  }

}
