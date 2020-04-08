package com.financialmanagement.FinancialManagement.dao;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.financialmanagement.FinancialManagement.entity.Accounts;
import com.financialmanagement.FinancialManagement.repository.AccountsRepository;
@Service
@Transactional
public class AccountsDao {
	
	@Autowired
	private AccountsRepository accRepo;

	public Accounts save(@Valid Accounts acc) {
		return accRepo.save(acc);		
	}

	public Page<Accounts> findAll(Pageable pageable) {
		
		
		Page<Accounts> page= accRepo.findAll(pageable);
		return page;
	}

	public Accounts findById(Long accIdentifier) {
		
		return accRepo.findById(accIdentifier).get();
	}
//	public List<Accounts> findByLedgerId(Long ledgerId) {
//		
//		return accRepo.findByLedgerId(ledgerId);
//	}

	public void deleteById(Long accIdentifier) {
			accRepo.deleteById(accIdentifier);
		
	}
}
