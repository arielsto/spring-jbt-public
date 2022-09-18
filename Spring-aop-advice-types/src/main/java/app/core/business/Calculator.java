package app.core.business;

import org.springframework.stereotype.Component;

import app.core.aspects.annotations.SecurityAnnotation;
import lombok.Data;

@Component 
@Data
@SecurityAnnotation
public class Calculator {
	
	public int add(int a, int b) {
		return a + b;
	}

	public int sub(int a, int b) {
		return a - b;
	}

	public int mul(int a, int b) {
		return a * b;
	}

	public int div(int a, int b) throws ArithmeticException {
		System.out.print("dividing " + a + " by " + b);
		int result = a/b;
		System.out.println(" = " + result);
		return result;
	}
	
	@SecurityAnnotation
	public void clearMemeory() {
		System.out.println("All memory cleareed permentaly");
	}

}
