package app.core.business.user;

import org.springframework.stereotype.Component;

@Component
public class UserActions {

	public void login(String password) {
		System.out.println("Logged in");
	}
	
	public void addAccount() {
		System.out.println("user account added");
	}

	public void removeAccount() {
		System.out.println("user account removed");
	}

}
