package core.app.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class FallBackController {
	
	@GetMapping("/fallback/serviceA")
	public String fallbackA(Throwable t) {
		return "Gateway fallback: cannot reach service A: "+t;
	}

	@GetMapping("/fallback/serviceB")
	public String fallbackB(Throwable t) {
		return "Gateway fallback: cannot reach service B: "+t;
	}
	
}
