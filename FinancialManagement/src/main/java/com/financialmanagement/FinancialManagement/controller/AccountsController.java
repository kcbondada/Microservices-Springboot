package com.financialmanagement.FinancialManagement.controller;




import javax.persistence.EntityListeners;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financialmanagement.FinancialManagement.dao.AccountsDao;
import com.financialmanagement.FinancialManagement.entity.Accounts;





@RestController
@EntityListeners(AuditingEntityListener.class)
@RequestMapping
public class AccountsController {
	
	@Autowired
	private AccountsDao accountsDao;
	

	@GetMapping("/accounts")
	public Page<Accounts> findAllAccount(Pageable pageable){
		 Page<Accounts> list=accountsDao.findAll(pageable);
		 return list;
	}
	@GetMapping("/accounts/{identifier}")
	public Accounts findById(@PathVariable(value = "identifier")Long accIdentifier) {
		return accountsDao.findById(accIdentifier);
	}

//	@GetMapping("/ledger/{identifier}/accounts")
//	public List<Accounts> findByLedger(@PathVariable(value = "identifier") Long ledgerId) {
//		return accountsDao.findByLedgerId(ledgerId);
//		
//	}
	
	@PostMapping("/accounts")
	public Accounts saveAcnt(@Valid @RequestBody Accounts acc) {
		return  accountsDao.save(acc);
		
	}
	 @DeleteMapping("/accounts/{identifier}")
	  public ResponseEntity<Accounts> deleteById(@PathVariable(value = "identifier")Long accIdentifier){
			
			Accounts findAcc = findById(accIdentifier);
			
			if(findAcc.equals(null)) {
				return ResponseEntity.notFound().build();
			}
			
			
			accountsDao.deleteById(findAcc.getAccIdentifier());
			return ResponseEntity.ok().build();
			
		}
}
