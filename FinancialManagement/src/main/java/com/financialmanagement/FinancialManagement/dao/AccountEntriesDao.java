package com.financialmanagement.FinancialManagement.dao;

import org.modelmapper.ModelMapper;

import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.financialmanagement.FinancialManagement.dto.AccountEntriesDto;
import com.financialmanagement.FinancialManagement.entity.AccountEntries;
import com.financialmanagement.FinancialManagement.repository.AccountEntryRepository;


@Service
public class AccountEntriesDao {
	
	@Autowired
	private AccountEntryRepository acceRepo;

	public  String addEntries(AccountEntriesDto entriesDto) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		AccountEntries accEntries=modelMapper.map(entriesDto, AccountEntries.class);
		accEntries.setBalance(balance(accEntries));
		acceRepo.save(accEntries);
		return "Entries Added SuccessFullly";
	}
	
	public double balance(AccountEntries accEntries) {
		double balance=accEntries.getBalance();
		if(accEntries.getType().equals("CREDIT")) {
			double amount=accEntries.getAmount();
			balance=balance+amount;
			return balance;
			
		}
		else if(accEntries.getType().equals("DEBIT")){
			double amount=accEntries.getAmount();
			balance=balance-amount;
			return balance;
			
		}
		
		return balance;
		
	}

	public List<AccountEntries> getAllEntries() {
		return acceRepo.findAll();
	}

}
