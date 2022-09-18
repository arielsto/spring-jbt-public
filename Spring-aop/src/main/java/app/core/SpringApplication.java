package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import app.core.business.admin.UsersAdmin;
import app.core.business.user.UserActions;
import app.core.aspects.StatAspect;

@ComponentScan
@Configuration
@EnableAspectJAutoProxy
public class SpringApplication {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringApplication.class);
		try(ctx){
			
			UsersAdmin userAdmin = ctx.getBean(UsersAdmin.class);
			System.out.println("ussserAdmin class: "+userAdmin.getClass());
			userAdmin.addUser();
			userAdmin.addUser();
			userAdmin.addUser();
			userAdmin.removeUser();
			
			UserActions userActions = ctx.getBean(UserActions.class);
			userActions.login("123");
			userActions.addAccount();
			userActions.removeAccount();
			
			System.out.println("=======");
			StatAspect stat = ctx.getBean(StatAspect.class);
			System.out.println("adds: "+ stat.getAddCount());
			System.out.println("removed: "+ stat.getRemoveCount());
			System.out.println("addRemovess: "+ stat.getAddRemoveCount());
		}
		
	}

}
