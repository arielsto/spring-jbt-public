package app.core.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.core.auth.User;
import app.core.auth.UserCredentials;
import app.core.services.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private AuthService service;

	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody User user){
		try {
			String token = service.register(user);
			return ResponseEntity.ok(token);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PostMapping("/login")
	private ResponseEntity<String> login(UserCredentials credentials) {
		try {
			String token = service.login(credentials);
			return ResponseEntity.ok(token);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
