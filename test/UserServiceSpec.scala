import org.mockito.Mockito._
import model.entity.User
import model.service.UserService
import org.joda.time.DateTime
import org.mockito.ArgumentMatchers.any
import org.scalatestplus.mockito.MockitoSugar
import org.scalatestplus.play.PlaySpec
import persistence.UserRepository
import scala.concurrent.ExecutionContext.Implicits.global

import scala.concurrent.Future

class UserServiceSpec extends PlaySpec with MockitoSugar {


  "UserService#getAllUser" should {
    "return a list of users" in {

      val userRepositoryMock = mock[UserRepository]

      // Configurar el comportamiento del mock para getUsersAll
      when(userRepositoryMock.find()).thenReturn(Future.successful(Seq(User(
        id = "1",
        email = "John@gmail.com",
        createdAt = new DateTime()))))
      val userService = new UserService(userRepositoryMock)

      // Llamar al método getUsersAll y verificar el resultado
      val result = userService.getUsersAll()
      result.map { users =>
        assert(users.length == 1)
        assert(users.head.email == "John@gmail.com")
      }
    }
  }

  "UserService#createVisitor" should {
    "create a user" in {
      val userRepositoryMock = mock[UserRepository]

      // Configurar el comportamiento del mock para createVisitor
      when(userRepositoryMock.crate(any[User])).thenReturn(Future.successful(1))
      val userService = new UserService(userRepositoryMock)

      // Llamar al método createVisitor y verificar el resultado
      val result = userService.createVisitor(User(id = "1", email = "John@gmail.com", new DateTime()))
      result.map { result =>
        assert(result == 1)
      }
    }
  }

}