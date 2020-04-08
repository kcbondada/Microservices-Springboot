package com.financialmanagement.FinancialManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.financialmanagement.FinancialManagement.entity.Ledger;

@Repository
public interface LedgerRepository extends JpaRepository<Ledger, Long>{

	
}
