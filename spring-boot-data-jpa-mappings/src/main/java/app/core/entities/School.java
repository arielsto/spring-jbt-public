package app.core.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@ToString(exclude = {"address","teachers"})

public class School {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id") // owner
	private Address address;
	
	@OneToMany(mappedBy = "school", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Teacher> teachers;
	
	public void setTeachers(List<Teacher> teachers) {
		for (Teacher teacher: teachers) {
			teacher.setSchool(this);
		}
		this.teachers = teachers;
	}

}
