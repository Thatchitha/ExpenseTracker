package com.example.Expense_Tracker.service;

import com.example.Expense_Tracker.dto.ExpenseCategory;
import com.example.Expense_Tracker.dto.ExpenseDto;

import java.util.List;

public interface ExpenseService {
    public void addData(ExpenseDto expenseDto);
    public List<ExpenseDto> getData();
    public void updateExpense(ExpenseDto expenseDto);
    public void deleteData(String date, ExpenseCategory typeOfExpense);
}
