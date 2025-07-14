package com.example.ExpenseTracker.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ExpenseTracker.PathModel.ExpenseModel;

public interface ExpenseRepositary extends JpaRepository<ExpenseModel, Long > {

}

