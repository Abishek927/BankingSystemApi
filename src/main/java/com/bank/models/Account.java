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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "account")
//@JsonIgnoreProperties(value = "customer")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="acc_number")
	private Long accountNo;
	@Column(name="account_type")
	private String accountType;
	@Column(name = "account_balance")
	private String balance;
	
	 @ManyToMany(mappedBy = "account", cascade = { CascadeType.ALL })
	 
	  private List<Customer> customer;

	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="branch_id_fk",referencedColumnName = "branch_id")
	@JsonBackReference(value="account")
	private Branch branch;
	
	
	

}
