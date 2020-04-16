package com.financialmanagement.FinancialManagement.controller;

import java.util.List;

import javax.persistence.EntityListeners;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.financialmanagement.FinancialManagement.dao.AccountsDao;
import com.financialmanagement.FinancialManagement.dao.LedgerDao;
import com.financialmanagement.FinancialManagement.entity.Accounts;
import com.financialmanagement.FinancialManagement.entity.Ledger;
import com.financialmanagement.FinancialManagement.repository.AccountsRepository;
import com.financialmanagement.FinancialManagement.repository.LedgerRepository;

@RestController
@EntityListeners(AuditingEntityListener.class)
@RequestMapping("/ledger")
public class LedgerController {
	
	@Autowired
	private LedgerDao ledgerDao;
	
	@Autowired
	private AccountsDao accountsDao;
	
	@Autowired
	private LedgerRepository ledgerRepository;
	@Autowired
	private AccountsRepository accrepo;
	
	@GetMapping
	public List<Ledger> findAllAccount(){
		return ledgerDao.findAll();
	}
		@GetMapping("/{identifier}")
		public Ledger findById(@PathVariable(value = "identifier")Long ledgerId) {
			return ledgerDao.findById(ledgerId);
		}
	
  @PostMapping
  public Ledger saveLedger(@Valid @RequestBody Ledger ld) {
	  return ledgerRepository.save(ld);
  }
  
  @PutMapping("/{identifier}")
  public Ledger updateLedger(@PathVariable(value = "identifier")Long ledgerId, @Valid @RequestBody Ledger ld) {
	  Ledger findLedger = findById(ledgerId);
	  if(findLedger.equals(null)) {
			return null;
		}
	  findLedger.setDescription(ld.getDescription());
	  findLedger.setName(ld.getName());
	  findLedger.setType(ld.getType());
	  Ledger updatedLd = ledgerDao.save(findLedger);
	  return updatedLd;
	  
  }
  @DeleteMapping("/{identifier}")
  public ResponseEntity<Ledger> deleteById(@PathVariable(value = "identifier")Long ledgerId){
		
		Ledger findLedger = findById(ledgerId);
		
		if(findLedger.equals(null)) {
			return  ResponseEntity.notFound().build();
		}
		
		
		ledgerDao.deleteById(ledgerId);
		return ResponseEntity.ok().build();
		
	}
  @PostMapping("/{id}/accounts")
	public Accounts save(@RequestBody Accounts acc,@Valid @PathVariable Long id) {
		Ledger en=ledgerRepository.findById(id).get();
		acc.setLedger(en);
		return accountsDao.save(acc);	
	}
	@GetMapping("{id}/accounts")
	public ResponseEntity<List<Accounts>> findAccByLedgerId(@Valid @PathVariable(value="id") Long ledgerId){
	    
	        Ledger en=ledgerRepository.findById(ledgerId).get();
	        if(en!=null) {
	        List<Accounts> acc=accrepo.findByLedger(en);
	        return new ResponseEntity<>(acc,HttpStatus.OK);
	        }
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);	
	}

}
