package com.agriculture.authentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.agriculture.authentication.models.DbSequenceCrop;
import com.agriculture.authentication.models.DbSequenceDealer;
import com.agriculture.authentication.models.DbSequenceFarmer;

import java.util.Objects;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

@Service
public class SequenceGeneratorService {

	    @Autowired
	    private MongoOperations mongoOperations;


    public int getSequenceNumberForCrop(String sequenceName) {
        
        Query query = new Query(Criteria.where("id").is(sequenceName));
	        //update the sequence no/	      
        Update update = new Update().inc("seq",500);
        DbSequenceCrop counter = mongoOperations
	                .findAndModify(query,
                         update, options().returnNew(true).upsert(true),
                        DbSequenceCrop.class);
	        return !Objects.isNull(counter) ? counter.getSeq() :1;
	    }
    
    public int getSequenceNumberForFarmer(String sequenceName) {
        //get sequence no
        Query query = new Query(Criteria.where("id").is(sequenceName));
        //update the sequence no
        Update update = new Update().inc("seq",2000);
        //modify in document
        //planter id will start from 100
        DbSequenceFarmer counter = mongoOperations
                .findAndModify(query,
                        update, options().returnNew(true).upsert(true),
                        DbSequenceFarmer.class);

        return !Objects.isNull(counter) ? counter.getSeq() :1;
    }
    
    
    public int getSequenceNumberForDealer(String sequenceName) {
        //get sequence no
        Query query = new Query(Criteria.where("id").is(sequenceName));
        //update the sequence no
        Update update = new Update().inc("seq",100);
        //modify in document
        //customer id will start from 200
        DbSequenceDealer counter = mongoOperations
                .findAndModify(query,
                        update, options().returnNew(true).upsert(true),
                        DbSequenceDealer.class);

        return !Objects.isNull(counter) ? counter.getSeq() :1;
    }

	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	}

