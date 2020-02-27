package routers

import controllers.UserController
import javax.inject.Inject
import play.api.routing.Router.Routes
import play.api.routing.SimpleRouter
import play.api.routing.sird._

class UserRouter @Inject()(controller: UserController) extends SimpleRouter {
  val prefix = "/user"

  override def routes: Routes = {
    case GET(p"/$id") =>
      ???
  }

}
