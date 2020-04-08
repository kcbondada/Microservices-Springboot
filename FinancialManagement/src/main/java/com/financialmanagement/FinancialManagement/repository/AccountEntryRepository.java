package com.financialmanagement.FinancialManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financialmanagement.FinancialManagement.entity.AccountEntries;

public interface AccountEntryRepository extends JpaRepository<AccountEntries, Long>{

}
