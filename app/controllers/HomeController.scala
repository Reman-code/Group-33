package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.db._


@Singleton
class HomeController @Inject()(db:Database,cc: ControllerComponents) extends AbstractController(cc) {

  val connection = db.getConnection()
  val statement = connection.createStatement
  val query = "SELECT * FROM teamdetails"
  val  resultset = statement.executeQuery(query)

  var i:Int=0
  var id = new Array[Int](4)
  var fn = new Array[String](4)
  var ln = new Array[String](4)
  var indexnum = new Array[String](4)
  var regnum = new Array[String](4)

  while(resultset.next()){
     id(i) = resultset.getInt("index")
     fn(i) = resultset.getString("first_name")
     ln(i) = resultset.getString("last_name")
     indexnum(i) = resultset.getString("index_number")
     regnum(i) = resultset.getString("reg_number")
     i=i+1
  }

  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.Home(id,fn,ln,indexnum,regnum))
  }

}
