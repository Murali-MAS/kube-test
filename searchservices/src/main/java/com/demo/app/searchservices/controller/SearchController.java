package com.demo.app.searchservices.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.app.entity.Candidate;
import com.demo.app.repos.CandidateRepository;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "/search")
public class SearchController {
	@Autowired
	CandidateRepository repos;

	@RequestMapping(path = "/candidates/search", method = RequestMethod.GET)
	@ResponseBody
	public List<Candidate> searchCandidates(@RequestParam String searchText) {

		List<Candidate> candidateList = new ArrayList<Candidate>();

		Iterator<Candidate> candidateIterator = repos.findAll().iterator();

		while (candidateIterator.hasNext()) {
			Candidate temp = candidateIterator.next();
			boolean isMatching = false;
			String tempSearchTxt = searchText.trim().toLowerCase();
			if (temp.getRto().toLowerCase().indexOf(tempSearchTxt) >= 0)
				isMatching = true;
			else if (temp.getAddress().toLowerCase().indexOf(tempSearchTxt) >= 0)
				isMatching = true;
			else if (temp.getDob().toLowerCase().indexOf(tempSearchTxt) >= 0)
				isMatching = true;
			else if (temp.getDoi().toLowerCase().indexOf(tempSearchTxt) >= 0)
				isMatching = true;
			else if (temp.getDoe().toLowerCase().indexOf(tempSearchTxt) >= 0)
				isMatching = true;
			else if (temp.getFirstName().toLowerCase().indexOf(tempSearchTxt) >= 0)
				isMatching = true;
			else if (temp.getLastName().toLowerCase().indexOf(tempSearchTxt) >= 0)
				isMatching = true;
			if (isMatching) {
				candidateList.add(temp);
			}
		}
		return candidateList;
	}
}
