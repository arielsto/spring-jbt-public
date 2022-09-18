package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import app.core.business.Calculator;
import app.core.business.Security;

@ComponentScan
@Configuration
@EnableAspectJAutoProxy
public class SpringApplication {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringApplication.class);
		try(ctx){

//			Security security = ctx.getBean(Security.class);
//			security.login();

			
			Calculator calc = ctx.getBean(Calculator.class);
			calc.div(100,20);
			
			System.out.println("\n\n");

			var result = calc.div(100,0);
			System.out.println("result = " + result);
			
			System.out.println("=======");
			
			calc.clearMemeory();
			

		}
		
	}

}
