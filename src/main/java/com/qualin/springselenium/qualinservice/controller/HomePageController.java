package com.qualin.springselenium.qualinservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.qualin.springselenium.qualinservice.dao.ReportingRepo;
import com.qualin.springselenium.qualinservice.entities.Reporting;

@Controller
@RequestMapping("/")
public class HomePageController {

	@Autowired
	ReportingRepo reporingRepo;
	
	@GetMapping("/")
	public String displayHomePageDetails(Model model) throws JsonProcessingException {
		
		List<Reporting> projDetails=reporingRepo.findAll();
		model.addAttribute("reportList", projDetails);
		return "homepage";
	}
	
	@PostMapping("/")
	public void saveRecord(@RequestBody Reporting repo) throws JsonProcessingException {
		reporingRepo.save(repo);
	}
	
}




