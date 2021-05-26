package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;

public interface JobSeekerService {
	DataResult<JobSeeker> getByNationalId(String nationalId);
	
	DataResult<JobSeeker> getByEmail(String email);
	
	Result add(JobSeeker candidate);
	
	DataResult<List<JobSeeker>> getAll();
}
