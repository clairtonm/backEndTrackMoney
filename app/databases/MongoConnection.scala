package databases

import org.mongodb.scala._
import com.typesafe.config.{Config, ConfigFactory}
import play.api.Logger

//TODO
// - Try MongoCredentialSettings

object MongoConnection extends App{

  def getMongoConnection: MongoClient = {
    val conf: Config = ConfigFactory.load()
    val mongoConf: Config = conf.getConfig("db.mongo")

    val mongoURI = s"mongodb+srv://${mongoConf.getString("username")}:" +
                             s"${mongoConf.getString("password")}@" +
                             s"${mongoConf.getString("url")}"

    try {
      println("Mongo Connected")
      MongoClient(mongoURI)
    } catch {
      case e: Exception =>
        println(s"Couldn't connect mongo: ${e.getMessage}")
        throw e
    }
  }

  def getMongoDatabase(mongoClient: MongoClient, database: String): MongoDatabase = {
    mongoClient.getDatabase(database)
  }

  def listDatabases(mongoClient: MongoClient): Unit = {
    mongoClient.listDatabaseNames().subscribe((result: String) => println(result))
  }

  def closeConnection(mongoClient: MongoClient): Unit = {
    mongoClient.close()
  }

}
