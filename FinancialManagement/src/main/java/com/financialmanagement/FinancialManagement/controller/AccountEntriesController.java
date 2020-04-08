package com.financialmanagement.FinancialManagement.controller;


import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financialmanagement.FinancialManagement.dao.AccountEntriesDao;
import com.financialmanagement.FinancialManagement.dto.AccountEntriesDto;
import com.financialmanagement.FinancialManagement.entity.AccountEntries;
import com.financialmanagement.FinancialManagement.entity.Entries;

@RestController
@RequestMapping("/entries")
public class AccountEntriesController {

	@Autowired
	private AccountEntriesDao accountEntriesDao;
	
	@PostMapping
	public String addEntries(@RequestBody Entries acce) {
		 ModelMapper modelmapper=new ModelMapper();
		 modelmapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		 AccountEntriesDto entriesDto= modelmapper.map(acce,AccountEntriesDto.class);
		 accountEntriesDao.addEntries(entriesDto);	
		return "Entries added";
		
	}
	@GetMapping
	public List<AccountEntries> getAllEntries(){
		return accountEntriesDao.getAllEntries();
	}
}
