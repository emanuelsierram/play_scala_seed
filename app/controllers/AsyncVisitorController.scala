package controllers

import model.entity.User
import model.service.{UserService, PoketWSPlay}

import scala.concurrent.{ExecutionContext, Future}
import play.api.mvc._
import play.api.libs.json.{JsValue, Json}

import javax.inject.Inject
class AsyncVisitorController @Inject()(val controllerComponents: ControllerComponents, userServiceAsync: UserService, wSPlay: PoketWSPlay)(implicit exec: ExecutionContext)extends BaseController{

  def getPoketApi = Action.async {
    wSPlay.getApiResponse().map { response =>
      Ok(response.body).as("application/json")
    }.recover {
      case e: Exception =>
        InternalServerError("Error al procesar la respuesta de la API: " + e.getMessage)
    }
  }

  def getUsers = Action.async {
    userServiceAsync.getUsersAll().map { user =>
      Ok(Json.toJson(user))
    }
  }

  def createUser: Action[User] = Action.async(parse.json[User]) { implicit request =>
    val user = request.body
    userServiceAsync.createVisitor(user).map { result =>
      Ok(s"$result Usuario creado con exito")
    }
  }







}
