package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="skills")
public class Skill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="technology_name")
	private String technologyName;

	@Column(name="programming_language")
	private String programmingLanguage;

	@Column(name="created_date")
	private LocalDate createdDate=LocalDate.now();

	@Column(name="is_deleted",columnDefinition = "boolean default false")
	private Boolean isDeleted=false;

	@ManyToOne()
	@JoinColumn(name="candidate_id")
	private Candidate candidate;

}
