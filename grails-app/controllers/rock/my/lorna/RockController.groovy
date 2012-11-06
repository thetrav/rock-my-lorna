package rock.my.lorna

import org.springframework.context.ResourceLoaderAware
import org.springframework.core.io.ResourceLoader
import javax.imageio.ImageIO
import java.awt.image.BufferedImage
import java.awt.geom.AffineTransform
import java.awt.RenderingHints
import java.awt.Graphics2D

class RockController implements ResourceLoaderAware{

   ResourceLoader resourceLoader

   def lorna() {
      try {
         def x = Integer.parseInt(params.x)
         def y = Integer.parseInt(params.y)
         def img = request.getFile('background-file')
         List<BufferedImage> lorna = [1,2,3,2].collect { ImageIO.read(resourceLoader.getResource("images/lorna_${it}.png").inputStream) }
         BufferedImage background = ImageIO.read(img.inputStream)

         List<BufferedImage> i = lorna.collect {
            def frame = deepCopy(background)
            frame.graphics.drawImage(it, x, y, null)
            scaleTo(frame, 500)
         }

         String filename = "lorna-rocking-${img.originalFilename.replaceFirst(~/\.[^\.]+$/, '')}.gif"

         response.contentType = 'application/octet-stream'
         response.setHeader 'Content-disposition', "attachment; filename=\"$filename\""

         AnimatedGifEncoder encoder = new AnimatedGifEncoder()
         encoder.start(response.outputStream)
         encoder.repeat = 0

         encoder.addFrame(i[0])
         encoder.delay = 100
         encoder.addFrame(i[1])
         encoder.delay = 100
         encoder.addFrame(i[2])
         encoder.delay = 200
         encoder.addFrame(i[3])
         encoder.delay = 100

         encoder.finish()
         response.outputStream.flush()
      }catch (t) {
         println("something went wrong ${t}")
         t.printStackTrace()
      }
   }

   static BufferedImage scaleTo(BufferedImage src, int max) {
      int w = src.getWidth();
      int h = src.getHeight();
      int largest = w > h ? w : h
      if(largest <= max) {
         src
      } else {
         double scale = max / largest
         BufferedImage scaledImage = new BufferedImage((int)(w * scale), (int)(h * scale), BufferedImage.TYPE_INT_ARGB)
         Graphics2D graphics2D = scaledImage.createGraphics()
         graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC)
         graphics2D.drawImage(src, AffineTransform.getScaleInstance(scale, scale), null)
         graphics2D.dispose()
         scaledImage
      }
   }

   static BufferedImage deepCopy(BufferedImage bi) {
    return new BufferedImage(bi.colorModel, bi.copyData(null), bi.colorModel.isAlphaPremultiplied(), null)
   }
}
