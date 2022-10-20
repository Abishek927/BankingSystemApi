package com.bank.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Entity
@Table(name="bank")

public class Bank {
	
	@Column(name = "bank_name")
	private String name;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="bank_code")
	private Long code;
	@Column(name="bank_address")
	private String address;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="bank")
	@JsonManagedReference(value = "branch")
	private List<Branch> branch;

	
	
	
	
	

}
