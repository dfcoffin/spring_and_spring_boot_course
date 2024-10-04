package com.oreilly.demo.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Donald F. Coffin, REMI Networks
 **/

class HelloControllerUnitTest {

	@Test
	void sayHello() {
		HelloController controller = new HelloController();
		Model model = new BindingAwareModelMap();
		String result = controller.sayHello("Dolly", model);
		assertAll("sayHello",
				() -> assertNotNull(model.getAttribute("user")),
				() -> assertEquals("Dolly", model.getAttribute("user")),
				() -> assertEquals("welcome", result)
		);
	}
}