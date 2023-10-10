package com.agriculture.dealerms.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "db_sequence")
@Data
@AllArgsConstructor
@NoArgsConstructor

	public class DbSequenceDealer {
	    @Id
	    private String  id;
	    private int seq;
		public int getSeq() {
			// TODO Auto-generated method stub
			return seq;
		}
		

}