package integration

import model.entity.User
import model.service.UserService
import org.joda.time.DateTime
import org.scalatest.concurrent.ScalaFutures.convertScalaFuture
import org.scalatestplus.play._
import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import persistence.UserRepository
import play.api.inject.guice.GuiceApplicationBuilder


class UserServiceIntegrationSpec extends PlaySpec with GuiceOneAppPerSuite {

  val userService: UserService = app.injector.instanceOf[UserService]
  val userRepository: UserRepository = app.injector.instanceOf[UserRepository]

  "UserService" should {

    "get all users" in {
      val result = userService.getUsersAll().futureValue
      result mustBe empty
    }

    "create a visitor" in {
      val user = User("1", "test@example.com", DateTime.now)
      val result = userService.createVisitor(user).futureValue

      result mustBe 1
      val users = userRepository.find().futureValue
      users must have size 1
      users.head mustBe user
    }

  }

  override def fakeApplication(): play.api.Application = {
    new GuiceApplicationBuilder()
      .configure("play.modules.enabled" -> "modules.H2DBModule")
      .build()
  }

}
