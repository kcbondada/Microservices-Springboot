package com.financialmanagement.FinancialManagement.dao;

import java.util.List;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.financialmanagement.FinancialManagement.entity.Ledger;

import com.financialmanagement.FinancialManagement.repository.LedgerRepository;
@Service
public class LedgerDao {
	@Autowired
	LedgerRepository ledgerRepository;
	
	public List<Ledger> findAll(){
		
		return ledgerRepository.findAll();
	}

	public Ledger save( @Valid Ledger ld) {
	return ledgerRepository.save(ld);
	}

	public Ledger findById(Long ledgerId) {
	
		return ledgerRepository.findById(ledgerId).get();
	}

	public void deleteById(Long ledgerId) {
		ledgerRepository.deleteById(ledgerId);
		
	}


}
