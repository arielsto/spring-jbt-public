package app.core.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(exclude = "school")
@Entity

public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int number;
	private String street;
	private String city;
	private String country;
	
	@JsonIgnore
	@OneToOne(mappedBy = "address") // inverse
	private School school;

}
