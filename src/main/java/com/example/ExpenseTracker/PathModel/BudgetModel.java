package com.example.ExpenseTracker.PathModel;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="budget")
public class BudgetModel {

    @Id
    private Long id;

    private double amount;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
}
