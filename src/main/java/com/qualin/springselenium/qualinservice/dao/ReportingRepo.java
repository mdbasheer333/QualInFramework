package com.qualin.springselenium.qualinservice.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.qualin.springselenium.qualinservice.entities.Reporting;

@Repository
public interface ReportingRepo extends MongoRepository<Reporting, Long> {

	List<Reporting> findAll();
	
}
