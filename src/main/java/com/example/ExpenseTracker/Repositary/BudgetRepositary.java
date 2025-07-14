package com.example.ExpenseTracker.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ExpenseTracker.PathModel.BudgetModel;

public interface BudgetRepositary extends JpaRepository<BudgetModel, Long> { }
