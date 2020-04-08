package com.financialmanagement.FinancialManagement.repository;





import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.financialmanagement.FinancialManagement.entity.AccountEntries;
import com.financialmanagement.FinancialManagement.entity.Accounts;
import com.financialmanagement.FinancialManagement.entity.Ledger;


public interface AccountsRepository extends JpaRepository<Accounts, Long>,PagingAndSortingRepository<Accounts, Long> {

public List<Accounts> findByLedger(Ledger ledger);
Page<Accounts> findAll(Pageable pageable);


	
}
