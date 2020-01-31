package com.demo.app.licensingservices.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.app.entity.Candidate;
import com.demo.app.repos.CandidateRepository;



@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "/license")
public class CandidateController {
	@Autowired
	CandidateRepository repos;
	@RequestMapping(path = "/candidates", method = RequestMethod.GET)
	@ResponseBody
	public List<Candidate> getAllCandidates() {
		List<Candidate> candidateList = new ArrayList<Candidate>();
		Iterator<Candidate> candidateIterator = repos.findAll().iterator();
		while(candidateIterator.hasNext()) {
			candidateList.add(candidateIterator.next());
		}
		return candidateList;
	}
	
	@RequestMapping(path = "/candidates/{candidateId}", method = RequestMethod.GET)
	@ResponseBody
	public Candidate getCandidateById(@PathVariable("candidateId") int candidateId) {
		Candidate candidate = new Candidate();
		if(repos.findById(candidateId) != null)
		{
			candidate = (Candidate)repos.findByCandidateId(candidateId);
		}
		return candidate;
	}
	@RequestMapping(path = "/candidates", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> addNewCandidate(@RequestParam String dob, 
								@RequestParam String doi,
								@RequestParam String doe, 
								@RequestParam String firstName, 
								@RequestParam String lastName,
								@RequestParam String address,
								@RequestParam String rto) {
		Map<String,String> toRet = new HashMap<String,String>();
		toRet.put("status", "candidate creation failed");
		Candidate candidate = new Candidate();
		candidate.setDob(dob);
		candidate.setDoi(doi);
		candidate.setDoe(doe);
		candidate.setFirstName(firstName);
		candidate.setLastName(lastName);
		candidate.setAddress(address);
		candidate.setRto(rto);
		if(repos.save(candidate) != null) {
			toRet.put("status", "candidate created successfully....");
		}
		return toRet;
	}
	@RequestMapping(path = "/candidates/{candidateId}", method = RequestMethod.PUT)
	@ResponseBody
	public Map<String,String> updateCandidate(@PathVariable("candidateId") int candidateId,
								@RequestParam String dob, 
								@RequestParam String doi,
								@RequestParam String doe, 
								@RequestParam String firstName, 
								@RequestParam String lastName,
								@RequestParam String address,
								@RequestParam String rto) {
		
		Map<String,String> toRet = new HashMap<String,String>();
		toRet.put("status", "candidate update failed");
		
		if(repos.findById(candidateId) != null)
		{
			Candidate candidate = (Candidate)repos.findByCandidateId(candidateId);
			candidate.setDob(dob);
			candidate.setDoi(doi);
			candidate.setDoe(doe);
			candidate.setFirstName(firstName);
			candidate.setLastName(lastName);
			candidate.setAddress(address);
			candidate.setRto(rto);
			repos.save(candidate);
			toRet.put("status", "candidate updated successfully...");
		}
		else {
			toRet.put("status", "user not exists");
		}
		return toRet;
	}
	@RequestMapping(path = "/candidates/{candidateId}", method = RequestMethod.DELETE)
	@ResponseBody
	public Map<String,String> removeCandidate(@PathVariable("candidateId") int candidateId) {
		Map<String,String> toRet = new HashMap<String,String>();
		toRet.put("status", "candidate removed failed");
		Candidate candidate = repos.findByCandidateId(candidateId);
		if(candidate != null)
		{
			repos.delete(candidate);
			toRet.put("status", "candidate removed successfully...");
		}
		else {
			toRet.put("status", "user not exists");
		}
		return toRet;
	}
	@RequestMapping(path = "/candidates/findByLastName", method = RequestMethod.GET)
	@ResponseBody
	public Candidate getByLastName(@RequestParam String lastName) {
		Candidate candidate = repos.findByLastName(lastName);
		return candidate;
	}
}

