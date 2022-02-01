package com.devopsdemo.demo;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	/** RestTemplateBuilder is a convenience in helping to quickly setup an
	 * instance of RestTemplate with all of the default settings
	*/
	@Bean
	RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {

		return args -> {

			/* For now, get the image manually and store in byte array for later use */
			String filePath = "/Users/jlinczak/dev/devops_demo/uploads/0.jpeg";
			byte[] imgByteArray = Files.readAllBytes(Paths.get(filePath));

			/* Place to store the resulting converted file */
			Path resultPath = Paths.get("/Users/jlinczak/dev/devops_demo/uploads/converted-0.png");

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.MULTIPART_FORM_DATA);

			MultiValueMap<String, String> fileMap = new LinkedMultiValueMap<>();
			ContentDisposition contentDisposition = ContentDisposition
																								.builder("form-data")
																								.name("file")
																								.filename("0.jpeg")
																								.build();

			fileMap.add(HttpHeaders.CONTENT_DISPOSITION, contentDisposition.toString());
			HttpEntity<byte[]> fileEntity = new HttpEntity<>(imgByteArray, fileMap);

			MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
			body.add("file", fileEntity);

			HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

			try {
				ResponseEntity<byte[]> image = restTemplate.exchange(
					"http://localhost:9000/convert?type=png",
					HttpMethod.POST,
					requestEntity,
					byte[].class
				);

				// Write the image to the file system for now
				Files.write(resultPath, image.getBody(), StandardOpenOption.CREATE_NEW);
				
			} catch (HttpClientErrorException e) {
				e.printStackTrace();
			}

		};

	};

}
