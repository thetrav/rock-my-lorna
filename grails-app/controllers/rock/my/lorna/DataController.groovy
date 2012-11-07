package rock.my.lorna

import com.gmongo.GMongo
import com.mongodb.MongoURI
import com.mongodb.DB


class DataController {
   def mongoService

   def simpleRemoteServiceCache

   def cached(guid) {
      def data
      if (simpleRemoteServiceCache.get(guid)) {
        data = simpleRemoteServiceCache.get(guid).getValue()
      } else {
        data = mongoService.db.images.findOne(guid:guid)
        simpleRemoteServiceCache.put( new net.sf.ehcache.Element(guid, data) )
      }
      data
   }


   def view() {
      def guid = params.fileName.replaceFirst(~/\.[^\.]+$/, '')

      def data = cached(guid)

      response.contentType = 'application/octet-stream'
      response.setHeader 'Content-disposition', "attachment; filename=\"${data.name}.gif\""

      response.outputStream.write(data.imageBytes)

      response.outputStream.flush()
   }

   def index() {
      def guids = mongoService.db.images.find([:], [guid:1]).collect {it.guid}
      render(view:"/rock/gallery", model: [guids:guids.reverse()])
   }
}
