package com.oreilly.demo.json;

import java.util.List;

/**
 *
 *  @author Donald F. Coffin, REMI Networks
 *
 **/

public record AstroResponse(String message,
							int number,
							List<Assignment> people) {
	record Assignment(String craft, String name) {
	}
}
