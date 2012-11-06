package rock.my.lorna

import com.gmongo.GMongo
import com.mongodb.MongoURI
import com.mongodb.DB


class DataController {
   def grailsApplication

   def view() {
      def config = grailsApplication.config.mongo
      def uri = "mongodb://${config.username}:${config.password}@${config.server}:${config.port}/${config.database}"
      GMongo mongo = new GMongo(new MongoURI(uri))
      try {
         DB db = mongo.getDB(config.database)
         db.authenticate(config.username, config.password.toCharArray())
         def guid = params.fileName.replaceFirst(~/\.[^\.]+$/, '')

         def data = db.images.findOne(guid:guid)

         response.contentType = 'application/octet-stream'
         response.setHeader 'Content-disposition', "attachment; filename=\"${data.name}.gif\""

         response.outputStream.write(data.imageBytes)

         response.outputStream.flush()
      } finally { mongo.close() }
   }
}
