package model.service

import model.entity.User
import persistence.UserRepositoryMySql

import javax.inject._
import scala.concurrent.Future


@Singleton
class UserService @Inject()(visitorRepositoryH2: UserRepositoryMySql){


  def getUsersAll(): Future[Seq[User]] = {
    visitorRepositoryH2.VisitorRepositoryH2.execute.find()
  }

  def createVisitor(user: User): Future[Int] = {
    visitorRepositoryH2.VisitorRepositoryH2.execute.crate(user)

  }
}