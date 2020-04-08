package com.financialmanagement.FinancialManagement.entity;



import java.util.Set;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;





@Entity
@Table(name="account")
public class Accounts {
	
@Id
@Column(name="acc_identifier")
private Long accIdentifier;
	
@Autowired
@Enumerated(EnumType.ORDINAL)
@Column(name="type")
private AccountType type;


@NotNull
@Column(name="name")
private String name;

@ElementCollection(fetch = FetchType.EAGER)
private Set<String> holders;

@ElementCollection(fetch = FetchType.EAGER)
private  Set<String> signatureAuthorities;


private Double balance;

@ManyToOne(targetEntity =Ledger.class,cascade = CascadeType.ALL)
@JoinColumn(name="ledger_Id",referencedColumnName = "ledgerId")
private Ledger ledger;




public void setLedger(Ledger ledger) {
	this.ledger = ledger;
}
public Ledger getLedger(){
	return ledger;
}

public Accounts(Long accIdentifier, AccountType type, @NotNull String name, Set<String> holders,
		Set<String> signatureAuthorities, Double balance, Ledger ledger) {
	super();
	this.accIdentifier = accIdentifier;
	this.type = type;
	this.name = name;
	this.holders = holders;
	this.signatureAuthorities = signatureAuthorities;
	this.balance = balance;
	this.ledger = ledger;
}

public Accounts() {
	
}



public AccountType getType() {
	return type;
}

public void setType(AccountType type) {
	this.type = type;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}



public Set<String> getHolders() {
	return holders;
}

public void setHolders(Set<String> holders) {
	this.holders = holders;
}

public Set<String> getSignatureAuthorities() {
	return signatureAuthorities;
}

public void setSignatureAuthorities(Set<String> signatureAuthorities) {
	this.signatureAuthorities = signatureAuthorities;
}

public Double getBalance() {
	return balance;
}

public void setBalance(Double balance) {
	this.balance = balance;
}
public Long getAccIdentifier() {
	return accIdentifier;
}
public void setAccIdentifier(Long accIdentifier) {
	this.accIdentifier = accIdentifier;
}


}
