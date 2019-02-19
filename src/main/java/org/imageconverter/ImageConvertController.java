package org.imageconverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
class ImageConvertController {

    @Autowired
    private ImageConvertService imageConvertService;

    @RequestMapping(value = "/convert", method = RequestMethod.POST, consumes = { "multipart/form-data" })
    public String convert(final @RequestParam MultipartFile file) {
        return imageConvertService.convert(new Image(file));
    }

    @RequestMapping(value = "/convertWithArea", method = RequestMethod.POST, consumes = { "multipart/form-data" })
    public String convertWithArea(final @RequestParam MultipartFile file, @RequestParam final int x, @RequestParam final int y, @RequestParam final int width, @RequestParam final int height) {
        return imageConvertService.convert(new Image(file, x, y, width, height));
    }
    
    @GetMapping("/convertTestLive")
    @ResponseStatus(HttpStatus.OK)
    public String ocr() {
        return "Convert live!";
    }
}