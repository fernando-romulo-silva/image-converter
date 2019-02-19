package org.imageconverter;

import java.awt.Rectangle;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;

import javax.imageio.ImageIO;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

@Service
class ImageConvertService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public String convert(final Image image) {
        
        log.info("Starts convert file {}.", image);
        
        try {

            final var bufferedImage = ImageIO.read(new ByteArrayInputStream(image.data.getBytes()));

            final var tesseract = new Tesseract();

            final var fileConfig = getPropertyFile();

            final var configuration = new PropertiesConfiguration(fileConfig);

            final var tesseractLanguage = configuration.getString("tesseract.language", "eng");
            final var tesseractFolder = configuration.getString("tesseract.folder", "/home/tesseract/tessdata"); 

            tesseract.setDatapath(tesseractFolder);
            tesseract.setLanguage(tesseractLanguage);

            final String result;
            
            if (image.x > 0 && image.y > 0 && image.width > 0 && image.height > 0) {
                result = tesseract.doOCR(bufferedImage, new Rectangle(image.x, image.y, image.width, image.height));
            } else {
                result = tesseract.doOCR(bufferedImage);
            }

            log.info("Ends convert file {} and result {}.", image, result);
            
            return result;
        } catch (final IOException ex) {
            final String msg = MessageFormat.format("Image {0} has IO error {1}.", image, ExceptionUtils.getRootCauseMessage(ex));
            log.error(msg, ex);
            return msg;
        } catch (final TesseractException | Error ex) {
            final String msg = MessageFormat.format("Image {0} has Tessarct error {1}.", ExceptionUtils.getRootCauseMessage(ex));
            log.error(msg, ex);
            return msg;
        } catch (final ConfigurationException ex) {
            final String msg = MessageFormat.format("Application has configuration properties error {0}.", ExceptionUtils.getRootCauseMessage(ex));
            log.error(msg, ex);
            return msg;
        } catch (final Throwable ex) {
            final String msg = MessageFormat.format("Unexpected error {0}.", ExceptionUtils.getRootCauseMessage(ex));
            log.error(msg, ex);
            return msg;
        } 
    }

    private String getPropertyFile() {

        final Path path = Paths.get("./config.properties"); // from same jar's folder

        if (Files.notExists(path)) {
            return "config.properties"; // from src/main/resources folder
        }

        return "./config.properties";
    }
}