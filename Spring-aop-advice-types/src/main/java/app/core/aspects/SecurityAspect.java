package app.core.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.core.business.Security;

@Component
@Aspect
public class SecurityAspect {
	
	@Autowired
	private Security security;
	
	@Around("annotatedMethodInClass() || annotatedMethodInClass()")
	public Object beforeSensativeMethod(ProceedingJoinPoint pjp) throws Throwable {
		if(security.isLoggedIn()) {
			return pjp.proceed();
		}
		throw new RuntimeException("You are not logged in, failed to invoke: "+pjp.getSignature().getName());
	}
	
	@Pointcut("@annotation(app.core.aspects.annotations.SecurityAnnotation)")
	public void annotatedMethod() {}

	@Pointcut("@target(app.core.aspects.annotations.SecurityAnnotation)")
	public void annotatedMethodInClass() {}

}
