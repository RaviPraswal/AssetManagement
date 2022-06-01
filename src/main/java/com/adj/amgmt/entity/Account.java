
package com.adj.amgmt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "ACCOUNT")
public class Account {

	@Id

	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "ID")
	private Integer accountId;

	@Column(name = "account_number")
	private String accountNumber;

	//@OneToOne(mappedBy = "account" )//variable name in Employee 
	//private Employee employee;
  
  
	//@OneToOne(cascade = CascadeType.ALL) private Employee employee;

	// 2.

	//@ManyToOne
	//private Employee employee;

}
