package com.financialmanagement.FinancialManagement.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;



@Entity
@Table(name="ledgers")
public class Ledger {

@Id
private Long ledgerId;

@Autowired
@Enumerated(EnumType.ORDINAL)
private AccountType type;

private String name;

@Lob
private String description;

private boolean showAccountsInChart;

//@OneToMany(targetEntity =Accounts.class,cascade = CascadeType.ALL)
//@JoinColumn(name="ld_acc",referencedColumnName = "accIdentifier")
//private Accounts accounts;
//
//
//public void setAccountsAccountIdentifier(String accIdentifier) {
//	accounts.setAccIdentifier(accIdentifier);
//}
//public void setAccountsGetType(Type type) {
//	accounts.setType(type);
//}
//public void setAccountsName(String name) {
//	accounts.setName(name);
//}
//public void setAccountsHolders(Set<String> holders) {
//	accounts.setHolders(holders);
//}
//
//public void setAccountsSignatureAuthorities(Set<String> signatureAuthorities) {
//	accounts.setHolders(signatureAuthorities);
//}
//public void setAccountsBalance(long balance) {
//	accounts.setBalance(balance);
//}

public Long getLedgerId() {
	return ledgerId;
}

public void setLedgerId(Long ledgerId) {
	this.ledgerId = ledgerId;
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

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public boolean isShowAccountsInChart() {
	return showAccountsInChart;
}

public void setShowAccountsInChart(boolean showAccountsInChart) {
	this.showAccountsInChart = showAccountsInChart;
}

}
