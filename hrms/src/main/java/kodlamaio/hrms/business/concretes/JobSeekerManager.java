package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.utilities.adapters.mernis.UserCheckService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service("JobSeekerManager")

public class JobSeekerManager implements JobSeekerService {

	
	private JobSeekerDao candidateDao;
	private UserCheckService userCheckService;
	
	
	@Autowired
	public JobSeekerManager(JobSeekerDao candidateDao,UserCheckService userCheckService) {
	
		super();
		this.candidateDao=candidateDao;
		this.userCheckService = userCheckService;
		
	}

	@Override
	public DataResult<JobSeeker> getByNationalId(String nationalId) {
		
		return new SuccessDataResult<JobSeeker>(this.candidateDao.findByNationalityId(nationalId));
	}

	@Override
	public DataResult<JobSeeker> getByEmail(String email) {
	
		return new SuccessDataResult<JobSeeker>(this.candidateDao.findByEmail(email));
	}



	@Override
	public DataResult<List<JobSeeker>> getAll() {
	
		return new SuccessDataResult<List<JobSeeker>>(this.candidateDao.findAll());
	}
	
	
	@Override
	public Result add(JobSeeker candidate) {
		
		if(!validationForJobSeeker(candidate)) {
			return new ErrorResult("Missing information...");
		}
		
		if(!checkIfRealPerson(candidate)) {
			return new ErrorResult("Invalid person...");
		}
		if(!checkIfEmailExists(candidate.getEmail())) {
			return new ErrorResult("Email already exist...");
		}
		if(!checkIfNationalityId(candidate.getIdentityNumber())) {
			return new ErrorResult("Nationality already exist...");
		}
		
		this.candidateDao.save(candidate);
		return new SuccessResult("Candidate added !");
	}
	
	
	// business rules
	private boolean checkIfEmailExists(String email) {
		if(this.candidateDao.findByEmail(email) !=null) {
			return false;
		}
		return true;
		
	}
	
	private boolean checkIfNationalityId(String nationalityId) {
		if(this.candidateDao.findByNationalityId(nationalityId)!=null) {
			return false;
		}
		return true;
	}
	
	private boolean checkIfRealPerson(JobSeeker candidate) {
		   if(!this.userCheckService.checkIfRealPerson(Long.parseLong(candidate.getIdentityNumber()), candidate.getFirstName().toUpperCase(new Locale("tr")), candidate.getLastName().toLowerCase(new Locale("tr")),
				   candidate.getBirthDate())) {
			   
			   return false;
		   }
		   return true;
			
		}
		

	private boolean validationForJobSeeker(JobSeeker candidate) {
		
		if(candidate.getFirstName() == null && candidate.getLastName() == null && candidate.getIdentityNumber() == null
				&& candidate.getBirthDate() == null && candidate.getEmail() == null) {
			return false;
					
		}
		return true;
	}
}
