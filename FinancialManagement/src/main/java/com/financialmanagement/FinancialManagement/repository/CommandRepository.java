package com.financialmanagement.FinancialManagement.repository;

import java.util.List;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.financialmanagement.FinancialManagement.entity.Accounts;
import com.financialmanagement.FinancialManagement.entity.Action;
import com.financialmanagement.FinancialManagement.entity.Commands;

@Repository
public interface CommandRepository extends JpaRepository<Commands, Action>,
PagingAndSortingRepository<Commands, Action>{
	
	Page<Commands> findAll(Pageable pageable);

	List<Commands> findByAcc(Accounts acc);



}
