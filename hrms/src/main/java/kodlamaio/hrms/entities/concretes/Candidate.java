package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="candidates")
@EqualsAndHashCode(callSuper=false) 
@PrimaryKeyJoinColumn(name = "user_id",referencedColumnName = "id")
public class Candidate extends User {

	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="nationality_id")
	private String nationalityId;
	
	@Column(name="date_of_birth")
	private LocalDate dateOfBirth;
	
	@Column(name="is_verified_by_email")
	private Boolean isEmailVerified;
	
	@Column(name="picture_url")
	private String pictureUrl;
//	
//	@Column(name ="github_address")
//	private String githubAddress;
//	
//	@Column(name="linkedin_address")
//	private String linkedinAddress;
	
	@Column(name="created_date")
	private LocalDate createdDate=LocalDate.now();
	
	@Column(name="is_deleted",columnDefinition = "boolean default false")
	private Boolean isDeleted=false;

	@OneToMany(mappedBy ="candidate")
	private List<CoverLetter> coverLetters;
	
	@OneToMany(mappedBy="candidate")
	private List<JobExperience> jobExperiences;
	
	@OneToMany(mappedBy="candidate")
	private List<Language> languages;
	
	@OneToMany(mappedBy="candidate")
	private List<Link> links;
	
	@OneToMany(mappedBy="candidate")
	private List<School> schools;
	
	@OneToMany(mappedBy="candidate")
	private List<Skill> skills;
}