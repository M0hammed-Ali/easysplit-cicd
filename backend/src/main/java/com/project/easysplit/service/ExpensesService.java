package com.project.easysplit.service;

import com.project.easysplit.model.Expenses;
import com.project.easysplit.repository.ExpensesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpensesService {
    private final ExpensesRepository expensesRepository;

    @Autowired
    public ExpensesService(ExpensesRepository expensesRepository) {
        this.expensesRepository = expensesRepository;
    }

    public List<Expenses> getExpenses() {
        return expensesRepository.findAll();
    }

    public void addNewExpense(Expenses expense) {
        expensesRepository.save(expense);
    }

    public void deleteExpense(Long id) {
        boolean exists = expensesRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Expense with id " + id + " does not exist");
        }
        expensesRepository.deleteById(id);
    }
}
