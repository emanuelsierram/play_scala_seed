package controllers


import model._
import model.entity.Visitor
import play.api.libs.json._
import play.api.mvc._

import javax.inject.{Inject, Singleton}


@Singleton
class  SyncVisitorController @Inject()(controllerComponents: ControllerComponents) extends AbstractController(controllerComponents)  {

/*

  // Endpoint para crear un nuevo Visitor
  def createVisitor = Action(parse.json) { request =>
    val visitorResult = request.body.validate[Visitor]
    visitorResult.fold(
      errors => BadRequest(Json.obj("message" -> JsError.toJson(errors))),
      visitor => {
        visitorService.createVisitor(visitor)
        Ok(Json.obj("message" -> "Visitante creado exitosamente"))
      }
    )
  }


  // Endpoint para obtener un Visitor
  def getAllVisitors = Action { implicit request =>
    val visitors = visitorService.getVisitorAll()
    Ok(Json.toJson(visitors))
  }

*/


}
