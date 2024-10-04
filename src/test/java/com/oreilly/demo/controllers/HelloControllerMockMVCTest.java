package com.oreilly.demo.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author Donald F. Coffin, REMI Networks
 **/

@WebMvcTest(HelloController.class)
public class HelloControllerMockMVCTest {

	@Autowired
	private MockMvc mvc;

	@Test
	void autowiringworked() {
		assertNotNull(mvc);
	}

	@Test
	void testHelloWithoutName() throws Exception {
		mvc.perform(get("/hello"))
				.andExpect(status().isOk())
				.andExpect(view().name("welcome"))
				.andExpect(model().attribute("user", "World"));
	}

	@Test
	void testHelloWithName() throws Exception {
		mvc.perform(get("/hello?name={name}", "Dolly"))
				.andExpect(status().isOk())
				.andExpect(view().name("welcome"))
				.andExpect(model().attribute("user", "Dolly"));
	}
}
