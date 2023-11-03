package model.entity

import org.joda.time.DateTime
import org.joda.time.format.ISODateTimeFormat
import play.api.libs.json._

trait Visitor {

  def id: String
  def createdAt: DateTime

}

case class Anonymous(id: String, createdAt: DateTime) extends Visitor
case class User(id: String, email:String, createdAt: DateTime) extends Visitor

object Visitor {

  // Define un formato personalizado para DateTime
  implicit val dateTimeFormat: Format[org.joda.time.DateTime] = new Format[org.joda.time.DateTime] {
    def writes(dateTime: org.joda.time.DateTime): JsValue =
      JsString(dateTime.toString) // Convierte DateTime a una cadena en el formato deseado

    def reads(json: JsValue): JsResult[org.joda.time.DateTime] = {
      json.validate[String].map { str =>
        org.joda.time.DateTime.parse(str) // Convierte la cadena JSON a DateTime
      }
    }
  }

  implicit val anonymousFormat: Format[Anonymous] = Json.format[Anonymous]
  implicit val userFormat: Format[User] = Json.format[User]

}



