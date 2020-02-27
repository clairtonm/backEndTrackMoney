package services

import com.typesafe.config.{Config, ConfigFactory}
import databases.MongoConnection
import org.mongodb.scala.bson.collection.immutable.Document
import org.mongodb.scala.{MongoDatabase, ScalaObservable}
import play.api.Logger

object MongoService extends App{

  val logger = Logger(getClass)

  val conf: Config = ConfigFactory.load()
  val mongoConf: Config = conf.getConfig("db.mongo")

  val databaseString: String = mongoConf.getString("database")
  val userCollectionString: String = mongoConf.getString("userCollection")

  def getTrackMoneyDatabase: Option[MongoDatabase] = {
    try {
      val mongoClient = MongoConnection.getMongoConnection
      val database = MongoConnection.getMongoDatabase(mongoClient, databaseString)
      Option(database)
    } catch {
      case e: Exception => {
        logger.logger.error(s"Couldn't connect with Mongo: ${e.getMessage}")
        logger.logger.error(s"${e.getStackTrace}")
        println(s"${e.getMessage}")
        None
      }
    }
  }

  def getUserById(database: Option[MongoDatabase], userId: String): Option[Unit] = {
    if (database.isDefined) {
      val userCollection = database.get.getCollection(userCollectionString)
      val user: Unit = userCollection.find().first()
//        .subscribe((results: Document) => println(results.toJson()),
//                  (e: Throwable) => println(s"There was an error: $e"),
//                  () => println("Completed!"))
      Option(user)
    } else {
      None
    }
  }

  def getUserByEmail(database: String, userEmail: String) = {
    ???
  }


  val mongodatabase = getTrackMoneyDatabase
  val user = getUserById(mongodatabase, "10")
  println(println("test"))
  println(user.getOrElse("Didn`t work"))
  println(println("test2"))


}
