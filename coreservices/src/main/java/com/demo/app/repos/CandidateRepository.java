package com.demo.app.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.app.entity.Candidate;


@Repository
public interface CandidateRepository extends CrudRepository<Candidate, Integer>{
public Candidate findByCandidateId(Integer id);
public Candidate findByLastName(String lname);
}
