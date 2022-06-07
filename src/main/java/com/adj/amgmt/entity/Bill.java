package com.adj.amgmt.entity;

import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Bill")
public class Bill {

//	private int id;
	private String fileName;
	private Binary fileBill;
}
