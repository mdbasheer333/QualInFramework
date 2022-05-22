package com.qualin.springselenium.qualinservice.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "QualInDBReport")
public class Reporting {

	 @Transient
	  public static final String SEQUENCE_NAME = "database_sequence";
	
	@Id
	private long id;

	@Override
	public String toString() {
		return "Reporting [id=" + id + ", tcName=" + tcName + ", tcDescription=" + tcDescription + ", tcStatus="
				+ tcStatus + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	private String tcName;
	private String tcDescription;
	private String tcStatus;

	public Reporting() {

	}

	public Reporting(String tcName, String tcDescription, String tcStatus) {
		this.tcName = tcName;
		this.tcDescription = tcDescription;
		this.tcStatus = tcStatus;
	}

	public String getTcName() {
		return tcName;
	}

	public void setTcName(String tcName) {
		this.tcName = tcName;
	}

	public String getTcDescription() {
		return tcDescription;
	}

	public void setTcDescription(String tcDescription) {
		this.tcDescription = tcDescription;
	}

	public String getTcStatus() {
		return tcStatus;
	}

	public void setTcStatus(String tcStatus) {
		this.tcStatus = tcStatus;
	}


}
