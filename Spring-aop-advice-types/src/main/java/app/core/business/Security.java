package app.core.business;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Security {
	
	private boolean loggedIn = false;
	
	public void login() {
		loggedIn = true;
	}


}
