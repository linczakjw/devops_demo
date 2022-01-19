package com.devopsdemo.demo;

/***
 * This was taken from Spring Boot's Uploading Files Guide located
 * at https://spring.io/guides/gs/uploading-files/ and adjusted to fit this
 * project
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FileUploadController {

  @PostMapping("/")
  public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
    /* This is where we would actually do the post and retrieve logic */
    redirectAttributes.addFlashAttribute("message", "You successfully uploaded " + file.getOriginalFilename() + "!");
    return "redirect:/";
  }

}
