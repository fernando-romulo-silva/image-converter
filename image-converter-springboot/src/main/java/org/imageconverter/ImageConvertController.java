package org.imageconverter;

import static org.springframework.http.HttpStatus.OK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
final class ImageConvertController {

    @Autowired
    private ImageConvertService imageConvertService;

    @PostMapping(value = "/convert", consumes = { "multipart/form-data" })
    public String convert(final @RequestParam MultipartFile file) {
	return imageConvertService.convert(new Image(file));
    }

    @PostMapping(value = "/convertWithArea", consumes = { "multipart/form-data" })
    public String convertWithArea(final @RequestParam MultipartFile file, @RequestParam final int x, @RequestParam final int y, @RequestParam final int width, @RequestParam final int height) {
	return imageConvertService.convert(new Image(file, x, y, width, height));
    }

    @GetMapping("/convertTestLive")
    @ResponseStatus(OK)
    public String ocr() {
	return "Convert live!";
    }
}