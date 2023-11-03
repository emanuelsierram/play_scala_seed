package controllers

import model.entity.User
import model.service.UserService

import scala.concurrent.{ExecutionContext, Future}
import play.api.mvc._
import play.api.libs.json.Json

import javax.inject.Inject
class AsyncVisitorController @Inject()(val controllerComponents: ControllerComponents, userServiceAsync: UserService)(implicit exec: ExecutionContext)extends BaseController{

  /*def getAllVisitors = Action.async { implicit request =>
    val visitors: Seq[Visitor] = visitorService.getVisitorAll()
    val futureVisitors: Future[Seq[Visitor]] = Future.successful(visitors)
    futureVisitors.map { visitors =>
      Ok(Json.toJson(visitors))
    }
  }*/

  def getUsers = Action.async {
    userServiceAsync.getUsersAll().map { user =>
      Ok(Json.toJson(user))
    }
  }

  def createUser: Action[User] = Action.async(parse.json[User]) { implicit request =>
    val user = request.body
    userServiceAsync.createVisitor(user).map { result =>
      Ok(s"Usuatio creado con exito")
    }
  }







}
