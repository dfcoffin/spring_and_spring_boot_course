package com.oreilly.demo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	private ApplicationContext context;

	@Test
	void contextLoads() {
		assertNotNull(context);
		int count = context.getBeanDefinitionCount();
		System.out.println("There are " + count + " beans in the application context");
		for (String name : context.getBeanDefinitionNames()) {
			System.out.println(name);
		}

		assertFalse(context.containsBean("restTemplate"));
		assertTrue(context.containsBean("restTemplateBuilder"));
	}

	@Test @Disabled
	void getBean() {
		assertThrows(NoSuchBeanDefinitionException.class,
				() -> context.getBean(RestTemplate.class));
	}
}
