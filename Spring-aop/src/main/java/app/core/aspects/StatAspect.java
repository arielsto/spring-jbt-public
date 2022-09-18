package app.core.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Aspect
@Data
public
class StatAspect {
	
	int addCount;
	int removeCount;
	int addRemoveCount;
	
	
	@Before("addMethodsPointcut()")
	public void countAdd() {
		addCount++;
	}

	@Before("removeMethodsPointcut()")
	public void countRemove() {
		removeCount++;
	}

	@Before("addMethodsPointcut() || removeMethodsPointcut()")
	public void countAddRemove() {
		addRemoveCount++;		
	}
	
	// pointcuts
	
	@Pointcut("execution(* add*(..))")
	public void addMethodsPointcut() {}

	@Pointcut("execution(* remove*(..))")
	public void removeMethodsPointcut() {}


}
