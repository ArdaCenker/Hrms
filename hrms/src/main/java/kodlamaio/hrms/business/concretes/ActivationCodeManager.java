package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ActivationCodeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ActivationCodeDao;
import kodlamaio.hrms.entities.concretes.ActivationCode;

@Service("VerificationCodeManager")
public class ActivationCodeManager implements ActivationCodeService {

	private ActivationCodeDao activationcodeDao;
	
	@Autowired
	public ActivationCodeManager(ActivationCodeDao activationcodeDao) {
		super();
		this.activationcodeDao =activationcodeDao;
	}

	@Override
	public Result add(ActivationCode code) {
		this.activationcodeDao.save(code);
		return new SuccessResult("Code added !");
	}

	@Override
	public DataResult<ActivationCode> getByUserIdAndVerificationCode(int userId, String verificationCode) {

		return new SuccessDataResult<ActivationCode>(this.activationcodeDao.findByUserIdAndVerificationCode(userId, verificationCode));
	}

	@Override
	public Result update(ActivationCode code) {
		this.activationcodeDao.save(code);
		return new SuccessResult("Code updated !");
	}
}
