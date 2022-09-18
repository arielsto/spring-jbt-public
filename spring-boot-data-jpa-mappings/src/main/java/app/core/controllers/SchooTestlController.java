package app.core.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/testschool")
public class SchooTestlController {
	
	
	@GetMapping(path = "/{user}")
	public String  greet1(@PathVariable String user) {
		return "hello: "+user;
	}
	
	@GetMapping(path = "/")
	public String  greet2(@RequestParam String user) {
		return "hello: "+user;
	}

}
