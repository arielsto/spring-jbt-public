package app.core.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import app.core.auth.User.Role;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;

@Component
public class JwtUtilImpl extends JwtUtilAbstract<User, Integer>{

	@Override
	public String generateToken(User user) {
		Map<String, Object> claims = new HashMap<>();
		claims.put("email", user.getEmail());
		claims.put("firstName", user.getEmail());
		claims.put("lastName", user.getLastName());
		claims.put("userName", user.getUserName());
		claims.put("role", user.getRole());
		// DO not include password or any sensitive info in a token
		return createToken(claims, user.getId());
	}

	@Override
	public User extractUser(String token) throws JwtException {
		Claims claims = extractAllClaims(token);
		int id = Integer.parseInt(claims.getSubject());
		String email = claims.get("email", String.class);
		String firstName = claims.get("firstName", String.class);
		String lastName = claims.get("lastName", String.class);
		String userName = claims.get("userName", String.class);
		Role role = claims.get("role", Role.class);
		User user = new User(id, email, null, firstName, lastName, userName, role);
		return user;
	}

}
