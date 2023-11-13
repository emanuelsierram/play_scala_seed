package persistence

import com.github.tototoshi.slick.PostgresJodaSupport._
import model.entity.User
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile

import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class UserRepository  @Inject()(protected val dbConfigProvider: DatabaseConfigProvider)(implicit executionContext: ExecutionContext) extends HasDatabaseConfigProvider[JdbcProfile] with Repository[User]{
  import profile.api._

    private val users = TableQuery[UserTable]

  override def crate(user: User): Future[Int] = db.run(users += user)

  override def find(): Future[Seq[User]] = db.run(users.result)



  private class UserTable(tag: Tag) extends Table[User](tag, "USERS") {
    def id = column[String]("ID", O.PrimaryKey, O.AutoInc)

    def email = column[String]("EMAIL")

    def createdAt = column[org.joda.time.DateTime]("FECHA")

    def * = (id, email, createdAt) <> ((User.apply _).tupled, User.unapply)
  }


}
