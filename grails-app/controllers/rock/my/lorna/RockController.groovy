package rock.my.lorna

import org.springframework.web.multipart.MultipartFile

class RockController {

    def lorna() {
      MultipartFile img = request.getFile('background-file')

      byte [] content = img.getBytes()
      String filename = "lorna-rocking-${img.getName()}"
      response.contentType = 'application/octet-stream'
      response.setHeader 'Content-disposition', "attachment; filename=\"$filename\""
      response.outputStream << content
      response.outputStream.flush()
    }
}
