package app.core.aspects;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
	
	@Before("execution(void addUser())")
	public void logeforeAddingUser() {
		System.out.println("attempting to add user");
	}

	@Before("execution(* app.core.business.user.*.*(..))")
	public void logeforeMethodsInUserPackage(JoinPoint jp) {
		System.out.println("attempting to call a method in User package. Method name: <" + jp.getSignature().getName() + "> args: <" + Arrays.toString(jp.getArgs())+">");
	}

	
}
