package com.github.anicolaspp.maprdbcleaner

import com.github.anicolaspp.maprdbcleaner.conf.Configuration
import org.ojai.store.{Connection, DriverManager}

object App {

  def main(args: Array[String]): Unit = {
    Configuration
      .parse(args)
      .foreach { config =>
        println("hello")

//        implicit val connection = getConnection
        //
        //        val query = buildQuery(config)
        //
        //        val documentStore: DocumentStore = connection.getStore(config.tableName)
        //
        //        val documents = documentStore.find(query)
        //
        //        documentStore.delete(documents, config.id)
        //
        //        documentStore.close()

        println("done")
      }
  }

  def getConnection = DriverManager.getConnection("ojai:mapr:")

  private def buildQuery(conf: Configuration)(implicit connection: Connection) =
    if (conf.allDocuments) allDocumentsQuery() else someDocumentsQuery(conf.query)

  private def allDocumentsQuery()(implicit connection: Connection) = connection.newQuery().build()

  private def someDocumentsQuery(query: String)(implicit connection: Connection) = connection.newQuery(query).build()
}




