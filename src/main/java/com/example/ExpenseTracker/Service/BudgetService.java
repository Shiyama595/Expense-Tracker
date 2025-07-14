package com.example.ExpenseTracker.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ExpenseTracker.PathModel.BudgetModel;
import com.example.ExpenseTracker.Repositary.BudgetRepositary;

import java.util.Optional;

@Service
public class BudgetService {

    @Autowired
    private BudgetRepositary budgetRepo;

    private final Long BUDGET_ID = 1L; // assuming only one budget row

    public double getBudget() {
        Optional<BudgetModel> optional = budgetRepo.findById(BUDGET_ID);
        return optional.map(BudgetModel::getAmount).orElse(0.0);
    }

    public void setBudget(double amount) {
        BudgetModel budget = budgetRepo.findById(BUDGET_ID).orElse(new BudgetModel());
        budget.setId(BUDGET_ID);
        budget.setAmount(amount);
        budgetRepo.save(budget); 
    }

    public void updateBudget(double change) {
        BudgetModel budget = budgetRepo.findById(BUDGET_ID).orElse(new BudgetModel());
        budget.setId(BUDGET_ID);
        budget.setAmount(budget.getAmount() + change);
        budgetRepo.save(budget);
    }
}
