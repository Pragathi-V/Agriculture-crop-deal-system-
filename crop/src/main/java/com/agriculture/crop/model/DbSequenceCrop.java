package com.agriculture.crop.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "db_sequence")
@Data
@AllArgsConstructor
@NoArgsConstructor

	public class DbSequenceCrop {
	    @Id
	    private String  id;
		private int seq;
		public int getSeq() {
			return seq;
		}
	    
		

}