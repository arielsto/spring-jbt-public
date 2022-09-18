package app.core.auth;

public class AuthException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AuthException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public AuthException(String message, Throwable cause) {
		super(message, cause);
	}

	public AuthException(String message) {
		super(message);
	}

	public AuthException(Throwable cause) {
		super(cause);
	}

}
