package com.financialmanagement.FinancialManagement.dao;




import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.financialmanagement.FinancialManagement.entity.Accounts;
import com.financialmanagement.FinancialManagement.entity.Commands;
import com.financialmanagement.FinancialManagement.repository.CommandRepository;

@Service
public class CommandsDao {

	@Autowired
	private CommandRepository coRepo;
	
//	@Autowired
//	private CommandsDto cmdDto;
	

	public Commands saveCmd(Commands cmd) {
		return coRepo.save(cmd);
		
	}

	public Page<Commands> findAll(Pageable pageable) {
		
	
		 Page<Commands> pagem = coRepo.findAll(pageable);
		 return pagem;
	}

	public List<Commands> findByAccount(Accounts acc) {
		
		 List<Commands> cmdList = coRepo.findByAcc(acc);
		 return cmdList;
	}
	
}
