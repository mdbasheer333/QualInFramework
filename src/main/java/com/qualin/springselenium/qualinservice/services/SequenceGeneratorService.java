package com.qualin.springselenium.qualinservice.services;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.qualin.springselenium.qualinservice.entities.CustomSequences;

@Service
public class SequenceGeneratorService {

	 @Autowired
	 private MongoTemplate mt;

	 public long getNextSequence(String seqName) {
		 
		 CustomSequences counter = mt.findAndModify(query(where("_id").is(seqName)),
		      new Update().inc("seq",1), options().returnNew(true).upsert(true),
		      CustomSequences.class);
		    return !Objects.isNull(counter) ? counter.getSeq() : 1;
		}
	 
	 
	
}
