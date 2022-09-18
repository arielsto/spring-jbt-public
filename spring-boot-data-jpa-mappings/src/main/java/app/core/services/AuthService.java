package app.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.core.auth.AuthException;
import app.core.auth.JwtUtilImpl;
import app.core.auth.User;
import app.core.auth.UserCredentials;
import app.core.auth.UserRepository;

@Service
public class AuthService {
	
	@Autowired
	private JwtUtilImpl jwtUtil;
	
	@Autowired
	private UserRepository repository;
	
	public String register(User user) {
		
		if (user.getUserName() == null || user.getUserName().length() < 3) {
			throw new AuthException("username mast be aat leasst 3 charcters");
		}
		if (user.getEmail() == null || !user.getEmail().contains("@")) {
			throw new AuthException("email must contain @");
		}
		
		repository.save(user);
		return jwtUtil.generateToken(user);
	}
	
	public String login(UserCredentials credentials) {
		User user = repository.findByEmail(credentials.getEmail()).orElseThrow(() -> new AuthException("No such used: "+credentials.getEmail()));
		if(!credentials.getPassword().equals(user.getPassword())) {
			throw new AuthException("login failed - bad credentials");
		}
		return jwtUtil.generateToken(user);
	}
}
