package com.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.entity.ExpenseAmountEntity;

public interface ExpenseRepository extends JpaRepository<ExpenseAmountEntity,Long> {

}
