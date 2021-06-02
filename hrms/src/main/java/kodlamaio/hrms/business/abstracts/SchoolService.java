package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.School;
import java.util.*;

public interface SchoolService {

	Result add(School school);

	DataResult<List<School>> findAllByCandidateIdOrderByGraduationYear(int candidateId);
}