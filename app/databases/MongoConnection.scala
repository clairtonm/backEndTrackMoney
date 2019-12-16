package databases

import org.mongodb.scala._
import com.typesafe.config.ConfigFactory

//TODO
// - Try MongoCredentialSettings

object MongoConnection extends App{

  val conf = ConfigFactory.load()
  val mongoConf = conf.getConfig("db.mongo")

  def getMongoConnection(): Unit = {
    val mongoURI = s"mongodb://${mongoConf.getString("username")}:" +
                             s"${mongoConf.getString("password")}@" +
                             s"${mongoConf.getString("url")}"

    val mongoClient = MongoClient(mongoURI)

  }

  def getMongoDatabase(): Unit = {
    ???
  }

}
