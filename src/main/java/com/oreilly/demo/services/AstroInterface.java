package com.oreilly.demo.services;

import com.oreilly.demo.json.AstroResponse;
import org.springframework.web.service.annotation.GetExchange;

/**
 * @author Donald F. Coffin, REMI Networks
 **/

public interface AstroInterface {

	@GetExchange("/astros.json")
	AstroResponse getResponse();
}
