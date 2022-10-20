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
@Table(name="loan")
//@JsonIgnoreProperties("customer")
public class Loan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="loan_id")
	private Long loanId;
	@Column(name="loan_type")
	private String loan_type;
	@Column(name = "loan_amount")
	private String amount;
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "branch_id_fk",referencedColumnName = "branch_id")
	@JsonBackReference(value="loan")
	private Branch branch1;
	
	
	@ManyToMany(mappedBy = "loan", cascade = { CascadeType.ALL })
	
    private List<Customer> customer;

	
	
}
