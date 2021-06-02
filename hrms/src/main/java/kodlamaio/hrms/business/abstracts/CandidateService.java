package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateService {
	DataResult<Candidate> getByNationalId(String nationalId);
	
	DataResult<Candidate> getByEmail(String email);
	
	Result add(Candidate candidate);
	
	DataResult<List<Candidate>> getAll();
}
