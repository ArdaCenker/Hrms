package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employer;

public interface AuthService {
	Result registerEmployer(Employer employer, String password);
	   
	Result registerCandidate(Candidate candidate, String password);
	   
	Result verifyEmail(int id, String activationCode);
}
