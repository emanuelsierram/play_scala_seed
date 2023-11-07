package model.service
import play.api.libs.ws.{WSClient, WSResponse}

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class PoketWSPlay @Inject()(ws: WSClient )(implicit exec: ExecutionContext) {

   def getApiResponse(): Future[WSResponse] = {
    val apiUrl = "https://pokeapi.co/api/v2/pokemon/ditto"
    ws.url(apiUrl)
      .get()
  }

  def postRequest(): Future[WSResponse] = {
    val apiUrl = "https://jsonplaceholder.typicode.com/posts" // Reemplaza esto con la URL de la API que deseas llamar

    val postData = Map(
      "userId" -> Seq("1"),
      "id" -> Seq("102"),
      "title" -> Seq("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"),
      "body"-> Seq("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto")
    ) // Reemplaza con los datos que deseas enviar en el cuerpo de la solicitud

    ws.url(apiUrl)
      .post(postData)
  }

  def processApiResponse(): Future[Unit] = {
    getApiResponse().map { response =>
      if (response.status == 200) {
        val responseBody = response.body

      } else {
        response.status
      }
    }
  }

  def processPostResponse(): Future[Unit] = {
    postRequest().map { response =>
      if (response.status == 201) {
        val responseBody = response.body
        println(s"Respuesta exitosa: $responseBody")
      } else {
        println(s"Error en la respuesta: ${response.status}")
      }
    }
  }


}
