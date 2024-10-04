package com.oreilly.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Donald F. Coffin, REMI Networks
 **/

@RestController
public class HelloRestController {

	@GetMapping("/rest")
	public Greeting greet(@RequestParam(defaultValue = "World") String name) {
		return new Greeting("Hello, " + name + "!");
	}
}

record Greeting(String message) {
}