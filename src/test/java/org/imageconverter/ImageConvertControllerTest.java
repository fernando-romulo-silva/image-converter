package org.imageconverter;

import static org.apache.commons.lang.StringUtils.deleteWhitespace;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import java.io.File;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class ImageConvertControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate = new TestRestTemplate(new RestTemplateBuilder());
    
    
    @Tag("integration")
    @Test
    public void ocrTest() throws RestClientException {

        final var result = restTemplate.<String> getForEntity("http://localhost:" + port + "/convertTestLive",  String.class);

        assertEquals(HttpStatus.OK.value(), result.getStatusCodeValue());
    }    
    

    // @Tag("integration")
    // @Test
    public void convertTest() throws RestClientException {

        final ClassLoader classLoader = ImageConvertControllerTest.class.getClassLoader();

        final File imageFileData = new File(classLoader.getResource("image.png").getFile());

        final var parameters = new LinkedMultiValueMap<String, Object>();
        parameters.add("file", new FileSystemResource(imageFileData));

        final HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "multipart/form-data");
        headers.set("Accept", "*/*");

        final var httpEntity = new HttpEntity<MultiValueMap<String, Object>>(parameters, headers);

        final var result = restTemplate.<String> postForEntity("http://localhost:" + port + "/convert", httpEntity, String.class);

        assertEquals(HttpStatus.OK.value(), result.getStatusCodeValue());
    }

    // @Test
    public void convertWithAreaTest() throws RestClientException {

        final ClassLoader classLoader = ImageConvertControllerTest.class.getClassLoader();

        final File imageFileData = new File(classLoader.getResource("image.png").getFile());

        final var parameters = new LinkedMultiValueMap<String, Object>();
        parameters.add("file", new FileSystemResource(imageFileData)); // load file into parameter
        parameters.add("x", 885);
        parameters.add("y", 1417);
        parameters.add("width", 1426);
        parameters.add("height", 57);

        final HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "multipart/form-data");
        headers.set("Accept", "*/*");

        final var httpEntity = new HttpEntity<MultiValueMap<String, Object>>(parameters, headers);

        final var result = restTemplate.<String> postForEntity("http://localhost:" + port + "/convertWithArea", httpEntity, String.class);

        assertEquals(HttpStatus.OK.value(), result.getStatusCodeValue());

        assertEquals("03399905748110000007433957701015176230000017040", deleteWhitespace(result.getBody()).replaceAll("[^x0-9]", ""));

        result.getBody();
    }

}
