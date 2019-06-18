package com.springlearn;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@RequestMapping("/hello")
	public String hello() {
		return "Hello World!";
	}
	
	@RequestMapping("/hellouser")
	public String hellowithparam(@RequestParam(name = "name", required = false, defaultValue = "minhduc") String name) {
		return "Hello, " + name;
	}
}
