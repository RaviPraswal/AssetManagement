package com.adj.amgmt.dto;

import org.hibernate.validator.constraints.NotBlank;

import com.adj.amgmt.entity.Asset;
import com.adj.amgmt.entity.Employee;

import lombok.Data;

@Data
public class AssetAssignmentDTO {

	private int id;
	
	private Asset asset;	

	private Employee employee;

	@NotBlank
	private String issueDate;

	@NotBlank(message = "This Field is Required")
	private String issueCondition;

	private String issueRemark;

	private String returnDate;

	private String returnCondition;

	private String reruntRemark;
	
	private String status;

}
