package com.leo.rest.ws.restfulwebservices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController
public class HelloWorldController {

	// GET
	// URI - /hello-world
	// method - "Hello World"
	@GetMapping(path = "/hello-world")
	public String HelloWorld() {
		return "Hello World";
	}
	
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean HelloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
}
