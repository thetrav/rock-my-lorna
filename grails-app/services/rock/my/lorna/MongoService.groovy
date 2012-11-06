package rock.my.lorna

import com.gmongo.GMongo
import javax.annotation.PostConstruct
import com.mongodb.MongoURI
import com.mongodb.DB


class MongoService {

   def transactional = false
   def grailsApplication

   GMongo mongo

   DB getDb() {
      DB db = mongo.getDB(config.database)
      if(!db.isAuthenticated()) {
         db.authenticate(config.username, config.password.toCharArray())
      }
      db
   }

   @PostConstruct
   void init() {
      def uri = "mongodb://${config.username}:${config.password}@${config.server}:${config.port}/${config.database}"
      mongo = new GMongo(new MongoURI(uri))
   }

   def getConfig() {
      grailsApplication.config.mongo
   }
}
