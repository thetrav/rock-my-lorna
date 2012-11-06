import com.gmongo.GMongo
import com.mongodb.MongoURI
import com.mongodb.DB

includeTargets << grailsScript("_GrailsInit")

target(main: "The description of the script goes here!") {
   def config = [
      server: "ds041347.mongolab.com",
      port: 41347,
      database: "rockthelorna",
      username: "rockmylorna",
      password: "lornamyrock"
   ]
   
   def uri = "mongodb://${config.username}:${config.password}@${config.server}:${config.port}/${config.database}"
   GMongo mongo = new GMongo(new MongoURI(uri))
   DB db = mongo.getDB(config.database)
   db.authenticate(config.username, config.password.toCharArray())

   db.images.ensureIndex(guid:1)
}

setDefaultTarget(main)
