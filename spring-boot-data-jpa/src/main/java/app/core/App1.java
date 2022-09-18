package app.core;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import app.core.entities.Person;
import app.core.repositories.PersonRepository;

@Component
@Order(1)
public class App1 implements CommandLineRunner {

	@Autowired
	private PersonRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Runner App1");
		Person p1 = new Person(0, "David", LocalDate.of(2000, 5, 27));
		Person p2 = new Person(0, "Leah", LocalDate.of(2005, 7, 27));
		
		repo.save(p1);
		repo.save(p2);

	}

}
