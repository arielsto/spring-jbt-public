package app.core.runners;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import app.core.entities.Address;
import app.core.entities.School;
import app.core.entities.Teacher;
import app.core.services.SchoolService;

@Component
public class Test1 implements CommandLineRunner {
	
	@Autowired
	SchoolService service;

	@Override
	public void run(String... args) throws Exception {
		
		Address address = new Address(0, 200, "Begin2", "Hifa2", "Israel2", null);
		
		List<Teacher> teachers = new ArrayList<>();
		teachers.add(new Teacher(0, "Moshe2", null));
		teachers.add(new Teacher(0, "Leah2", null));
		//teachers.add(new Teacher(0, "Rachel2", null));
		
		School school = new School();
		school.setName("Atidim");
		school.setAddress(address);
		school.setTeachers(teachers);
		
		service.createSchool(school);
	}

}
