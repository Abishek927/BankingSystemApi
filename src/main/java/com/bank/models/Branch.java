package com.bank.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Entity
@Table(name="branch")
//@JsonIgnoreProperties(value ={"account","loan"})
public class Branch {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="branch_id")
	private Long branchId;
	@Column(name="branch_name")
	private String name;
	@Column(name="branch_address")
	private String address;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="bank_code_fk",referencedColumnName = "bank_code")
	@JsonBackReference(value = "branch")
	private Bank bank;
	
	
	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "branch")
	@JsonManagedReference(value = "account")
	private List<Account> account;
	
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "branch1")
	@JsonManagedReference(value="loan")
	
	private List<Loan> loan;


	

}
