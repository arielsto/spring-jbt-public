package app.core.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
	
	// before
	
	@Before("div()")
	public void beforeDiv(JoinPoint jp) {
		System.out.println(">>> before: " + jp.getSignature().getName());
	}
	
	// after
	@After("div()")
	public void afterDiv(JoinPoint jp) {
		System.out.println(">>> after: " + jp.getSignature().getName());
	}

	// after returning
	@AfterReturning(pointcut = "div()", returning = "result")
	public void afterReturningFromDiv(JoinPoint jp, int result) {
		System.out.println(">>> after returning: " + jp.getSignature().getName() + " = " + result);
	}
	
	// after throwing
	@AfterThrowing(pointcut = "div()", throwing = "t")
	public void afterThrowingFromDiv(JoinPoint jp, Throwable t) {
		System.out.println(">>> after throwing from: " + jp.getSignature().getName() + " Error: " + t.getMessage());
	}

	// around
	@Around("div()")
	public Object aroundDiv(ProceedingJoinPoint pjp)  {
		// before
		System.out.println("Around before");
		
		// invoke the joinpoint
		Object result;
		try {
			result = pjp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			result = -1;
		}
		
		// after
		System.out.println("Around after");
		
		return result;
	}
	
	@Pointcut("execution(int add(int, int))") public void add() {}
	@Pointcut("execution(int sub(int, int))") public void sub() {}
	@Pointcut("execution(int mul(int, int))") public void mul() {}
	@Pointcut("execution(int div(int, int))") public void div() {}
	
}
