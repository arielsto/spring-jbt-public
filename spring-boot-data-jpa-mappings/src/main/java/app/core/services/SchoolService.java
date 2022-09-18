package app.core.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.core.entities.School;
import app.core.repositories.SchoolRepository;

@Service
@Transactional
public class SchoolService {
	
	@Autowired
	private SchoolRepository repo;


	public int createSchool(School school) {
		if (!repo.existsById(school.getId())) {
			repo.save(school);
			return school.getId();
		} else {
			throw new RuntimeException("crate school failed - already exists");
		}
	}
	
	public School getSchool(int id) {
		return repo.findById(id)
				.orElseThrow(() -> new RuntimeException("getSchool failed - not found"));
		
	}
	
	public void updateSchool(School school) {
		if (repo.existsById(school.getId())) {
			repo.save(school);
		} else {
			throw new RuntimeException("updateSchool failed - already exists");
		}
	}
	
	public void deleteSchool(int id) {
		repo.deleteById(id);
		
	}

	
}
