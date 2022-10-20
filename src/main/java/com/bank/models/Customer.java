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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Entity
@Table(name="customer")

public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="customer_id")
	private Long customerId;
	@Column(name="customer_name")
	private String name;
	@Column(name="customer_phone_no")
	private String phone;
	@Column(name="customer_address")
	private String address;
	
    @ManyToMany(cascade = {
            CascadeType.ALL
        })
        @JoinTable(
            name = "account_customer",
            joinColumns = {
                @JoinColumn(name = "customer_id")
            },
            inverseJoinColumns = {
                @JoinColumn(name = "account_no")
            }
        )
   
        private List<Account> account;

	
	
    @ManyToMany(cascade = {
            CascadeType.ALL
        })
        @JoinTable(
            name = "customer_loan",
            joinColumns = {
                @JoinColumn(name = "customer_id")
            },
            inverseJoinColumns = {
                @JoinColumn(name = "loan_id")
            }
        )
    
    
	private List<Loan> loan;

	
	
	
	

}
