package com.devopsdemo.demo.controller;

import java.io.IOException;

/***
 * This was taken from Spring Boot's Uploading Files Guide located
 * at https://spring.io/guides/gs/uploading-files/ and adjusted to fit this
 * project
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FileUploadController {

	@GetMapping("/")
	public String listUploadedFiles(Model model) throws IOException {
		return "uploadForm";
	}

}
