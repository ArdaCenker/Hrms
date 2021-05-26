package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ActivationCode;

public interface ActivationCodeService {
	Result add(ActivationCode code);
	
	DataResult<ActivationCode> getByUserIdAndVerificationCode(int userId, String verificationCode);
	
	Result update(ActivationCode code);
}
