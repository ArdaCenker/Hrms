package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.VerificationCode;

public interface VerificationCodeService {
	Result add(VerificationCode code);
	
	DataResult<VerificationCode> getByUserIdAndVerificationCode(int userId, String verificationCode);
	
	Result update(VerificationCode code);
}
