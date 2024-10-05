package com.oreilly.demo.config;

import com.oreilly.demo.services.AstroInterface;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

/**
 * @author Donald F. Coffin, REMI Networks
 **/

@Configuration
public class AppConfig {

	@Bean
	public RestTemplate astroRestTemplate(RestTemplateBuilder builder,
										  @Value("${astro.baseUrl}") String baseUrl) {
		return builder.rootUri(baseUrl).build();
	}

	@Bean
	public RestTemplate anotherRestTemplate(RestTemplateBuilder builder) {
		return builder.rootUri("https://other.html").build();
	}

	@Bean
	public AstroInterface astroInterface(@Value("${astro.baseUrl}") String baseUrl) {
		WebClient client = WebClient.create(baseUrl);
		WebClientAdapter adapter = WebClientAdapter.create(client);
		HttpServiceProxyFactory factory =
				HttpServiceProxyFactory.builderFor(adapter)
				.build();
		return factory.createClient(AstroInterface.class);
	}
}
