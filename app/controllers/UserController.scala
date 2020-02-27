package controllers

import javax.inject.Inject
import play.api.Logger
import play.api.mvc.{Action, ControllerComponents}

import scala.concurrent.ExecutionContext

class UserController @Inject()(cc: ControllerComponents)(implicit ec: ExecutionContext){

  private val logger = Logger(getClass)

//  def getUser = Action { implicit request =>
//    ???
//  }

}
