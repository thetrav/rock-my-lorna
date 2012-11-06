package rock.my.lorna

import org.springframework.web.multipart.MultipartFile
import org.springframework.context.ResourceLoaderAware
import org.springframework.core.io.ResourceLoader
import org.springframework.core.io.Resource
import javax.imageio.ImageIO
import java.awt.image.BufferedImage

class RockController implements ResourceLoaderAware{

   ResourceLoader resourceLoader

   def lorna() {
      MultipartFile img = request.getFile('background-file')

      Resource first = resourceLoader.getResource("images/glyphicons-halflings.png")
      Resource second = resourceLoader.getResource("images/glyphicons-halflings.png")

      BufferedImage firstImg = ImageIO.read(first.inputStream)
      BufferedImage secondImg = ImageIO.read(second.inputStream)

      BufferedImage thirdImg = ImageIO.read(img.inputStream)

      String filename = "lorna-rocking-${img.originalFilename.replaceFirst(~/\.[^\.]+$/, '')}.gif"

      response.contentType = 'application/octet-stream'
      response.setHeader 'Content-disposition', "attachment; filename=\"$filename\""

      AnimatedGifEncoder encoder = new AnimatedGifEncoder()
      encoder.start(response.outputStream)

      encoder.delay = 200
      encoder.repeat = 0
      encoder.addFrame(firstImg)
      encoder.addFrame(secondImg)
      encoder.addFrame(thirdImg)
      encoder.finish()
      response.outputStream.flush()
   }
}
