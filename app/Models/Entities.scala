package Models

import play.api.libs.json.Writes
import play.api.libs.json._
import play.api.libs.functional.syntax._

object Entities {

  case class User(name: String, email: String)

  implicit val userWrites = new Writes[User] {
    def writes(user: User) = Json.obj(
      "name" -> user.name,
      "email" -> user.email
    )
  }

  implicit val userReads: Reads[User] = (
    (JsPath \ "name").read[String] and
      (JsPath \ "email").read[String]
  )(User.apply _)

}
