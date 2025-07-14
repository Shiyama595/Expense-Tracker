package com.example.ExpenseTracker.Controller;

import com.example.ExpenseTracker.PathModel.ExpenseModel;
import com.example.ExpenseTracker.Service.BudgetService;
import com.example.ExpenseTracker.Service.ExpenseService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ExpenseController {

    @Autowired
    private ExpenseService service;

    @Autowired
    private BudgetService budgetService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/dummyLogin")
    public String dummyLogin(HttpServletRequest request, Model model) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("shiyama".equals(username) && "root".equals(password)) {
            request.getSession().setAttribute("user", "shiyama");
            return "redirect:/index";
        } else {
            model.addAttribute("error", "Invalid credentials");
            return "login";
        }
    }

    @GetMapping("/set-budget")
    public String showSetBudgetForm() {
        return "set-budget";
    }

    @PostMapping("/set-budget")
    public String submitBudget(@RequestParam("budget") double budget) {
        service.deleteAll(); // delete all previous transactions
        budgetService.setBudget(budget);
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String viewHome(Model model) {
        model.addAttribute("listExpenses", service.listAll());
        model.addAttribute("budget", budgetService.getBudget());
        return "index";
    }

    @GetMapping("/add")
    public String addExpenseForm(Model model) {
        model.addAttribute("expense", new ExpenseModel());
        return "add-expense";
    }

    @PostMapping("/save")
    public String saveExpense(@ModelAttribute("expense") ExpenseModel expense) {
        ExpenseModel oldExpense = null;

        if (expense.getId() != 0) {
            oldExpense = service.get(expense.getId());
            if (oldExpense != null) {
                if ("Expense".equals(oldExpense.getType())) {
                    budgetService.updateBudget(oldExpense.getAmount());
                } else {
                    budgetService.updateBudget(-oldExpense.getAmount());
                }
            }
        }

        service.save(expense);

        if ("Expense".equals(expense.getType())) {
            budgetService.updateBudget(-expense.getAmount());
        } else {
            budgetService.updateBudget(expense.getAmount());
        }

        return "redirect:/index";
    }

    @GetMapping("/edit/{id}")
    public String editExpenseForm(@PathVariable Long id, Model model) {
        ExpenseModel existing = service.get(id);
        if (existing == null) {
            return "redirect:/index";
        }
        model.addAttribute("expense", existing);
        return "add-expense";
    }

    @GetMapping("/delete/{id}")
    public String deleteExpense(@PathVariable Long id) {
        ExpenseModel expense = service.get(id);
        if (expense != null) {
            service.delete(id);
            if ("income".equalsIgnoreCase(expense.getType())) {
                budgetService.updateBudget(-expense.getAmount());
            } else {
                budgetService.updateBudget(expense.getAmount());
            }
        }
        return "redirect:/index";
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
