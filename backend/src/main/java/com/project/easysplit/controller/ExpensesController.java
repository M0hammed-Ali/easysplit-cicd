package com.project.easysplit.controller;

import com.project.easysplit.model.Expenses;
import com.project.easysplit.service.ExpensesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/expenses")
@CrossOrigin
public class ExpensesController {
    private final ExpensesService expensesService;
   // private final Expenses expenses;

    @Autowired
    public ExpensesController(ExpensesService expensesService) {
        this.expensesService = expensesService;
    }
//    @Autowired
//    public ExpensesController(ExpensesService expensesService, Expenses expenses) {
//        this.expensesService = expensesService;
//        this.expenses = expenses;
//    }

    @GetMapping
    public List<Expenses> getExpenses() {
        return expensesService.getExpenses();
    }

    @PostMapping
    public void addNewExpense(@RequestBody Expenses expense) {
        expensesService.addNewExpense(expense);
    }

    @DeleteMapping(path = "{id}")
    public void deleteExpense(@PathVariable("id") Long id) {
        expensesService.deleteExpense(id);
    }
}
