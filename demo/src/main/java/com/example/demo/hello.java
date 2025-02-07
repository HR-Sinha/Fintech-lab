*package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class hello {
 @GetMapping("/")
 public String hello() {
	 return "WELCOME MIT-FIS LAB";
 }
}
*

@RestController
public class MyController {

    @GetMapping("/")
    public String home() {
        return "Hello, world!";
    }
}
