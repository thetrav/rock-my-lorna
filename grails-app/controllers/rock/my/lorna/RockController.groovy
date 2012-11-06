package rock.my.lorna

import org.springframework.context.ResourceLoaderAware
import org.springframework.core.io.ResourceLoader
import javax.imageio.ImageIO
import java.awt.image.BufferedImage
import java.awt.geom.AffineTransform
import java.awt.RenderingHints
import java.awt.Graphics2D

class RockController implements ResourceLoaderAware {

   ResourceLoader resourceLoader
   def mongoService

   def lorna() {

      def x = Integer.parseInt(params.x)
      def y = Integer.parseInt(params.y)
      def scale = Double.parseDouble(params.scale)
      def img = request.getFile('background-file')
      def id = UUID.randomUUID().toString()
      List<BufferedImage> lorna = [1, 2, 3, 2].collect { ImageIO.read(resourceLoader.getResource("images/lorna_${it}.png").inputStream) }
      BufferedImage background = ImageIO.read(img.inputStream)

      List<BufferedImage> i = lorna.collect {
         def frame = deepCopy(background)
         Graphics2D g = frame.graphics
         g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC)
         def xform = AffineTransform.getTranslateInstance(x, y)
         xform.scale(scale, scale)
         g.drawImage(it, xform, null)
         scaleTo(frame, 500)
      }

      String filename = "lorna-rocking-${img.originalFilename.replaceFirst(~/\.[^\.]+$/, '')}"

      File temp = File.createTempFile(filename, ".gif")

      AnimatedGifEncoder encoder = new AnimatedGifEncoder()
      FileOutputStream tempOut = new FileOutputStream(temp)
      try {
         encoder.start(tempOut)
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
      } finally {
         tempOut.close()
      }

      mongoService.db.images.insert([
         guid: id,
         x: x,
         y: y,
         name: filename,
         imageBytes: temp.bytes
      ])
      redirect(action: "view", params: [id: id])
   }

   def view() {
      render(view: "lorna", model: [lorna: params.id])
   }

   static BufferedImage scaleTo(BufferedImage src, int max) {
      int w = src.getWidth();
      int h = src.getHeight();
      int largest = w > h ? w : h
      if (largest <= max) {
         src
      } else {
         double scale = max / largest
         BufferedImage scaledImage = new BufferedImage((int) (w * scale), (int) (h * scale), BufferedImage.TYPE_INT_ARGB)
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
