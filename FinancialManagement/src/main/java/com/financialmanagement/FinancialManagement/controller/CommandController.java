package com.financialmanagement.FinancialManagement.controller;



import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financialmanagement.FinancialManagement.dao.AccountsDao;
import com.financialmanagement.FinancialManagement.dao.CommandsDao;
import com.financialmanagement.FinancialManagement.entity.Accounts;
import com.financialmanagement.FinancialManagement.entity.Commands;

@RestController
@RequestMapping
public class CommandController {
	
	@Autowired
	private CommandsDao coDa;
	
	@Autowired
	private AccountsDao accountsDao;
	
	@PostMapping("/accounts/{id}/commands")
	public Commands saveCommands(@Valid @RequestBody Commands cmd,@PathVariable(value="id") long accIdentifier) {
		
		Accounts acc=accountsDao.findById(accIdentifier);
		cmd.setAcc(acc);
		return coDa.saveCmd(cmd);
		
	}
	
	@GetMapping("/accounts/{id}/commands")
	public List<Commands> findCommandByAcc(@PathVariable(value="id") long accIdentifier){
		
		Accounts acc=accountsDao.findById(accIdentifier);
		
		return coDa.findByAccount(acc); 
	}

}
