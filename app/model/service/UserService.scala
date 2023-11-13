package model.service

import model.entity.User
import persistence.UserRepository

import javax.inject._
import scala.concurrent.Future


@Singleton
class UserService @Inject()(visitorRepository: UserRepository){


  def getUsersAll(): Future[Seq[User]] = {
    visitorRepository.find()
  }

  def createVisitor(user: User): Future[Int] = {
    visitorRepository.crate(user)

  }
}