package kodlamaio.hrms.dataAccess.abstracts;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.School;

public interface SchoolDao extends JpaRepository<School,Integer> {

	List<School> findAllByCandidate_IdOrderByGraduationYear(int candidateId);

}