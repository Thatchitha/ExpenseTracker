package com.example.Expense_Tracker.service.impl;

import com.example.Expense_Tracker.dto.ExpenseCategory;
import com.example.Expense_Tracker.dto.ExpenseDto;
import com.example.Expense_Tracker.model.Expense;
import com.example.Expense_Tracker.repository.ExpenseRepository;
import com.example.Expense_Tracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class ExpenseServiceImpl implements ExpenseService {
    @Autowired
    private ExpenseRepository expenseRepository;
    @Override
    public void addData(ExpenseDto expenseDto) {
        Expense existing = expenseRepository.findByDateAndTypeOfExpense(expenseDto.getDate(),expenseDto.getTypeOfExpense());
        if (existing!=null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Date already exists");
        }
        Expense expense=new Expense();
        expense.setDate(expenseDto.getDate());
        expense.setAmount(expenseDto.getAmount());
        expense.setCategory(expenseDto.getCategory());
        expense.setTypeOfExpense(expenseDto.getTypeOfExpense());
        expenseRepository.save(expense);

    }

    @Override
    public List<ExpenseDto> getData() {
        List<Expense> expenses=expenseRepository.findAll();
        List<ExpenseDto> expenseDtos=new ArrayList<>();
        for(Expense expense:expenses)
        {
            ExpenseDto expenseDto=new ExpenseDto();
            expenseDto.setDate(expense.getDate());
            expenseDto.setAmount(expense.getAmount());
            expenseDto.setCategory(expense.getCategory());
            expenseDto.setTypeOfExpense(expense.getTypeOfExpense());
            expenseDtos.add(expenseDto);
        }
        return expenseDtos;
    }

    @Override
    public void updateExpense(ExpenseDto expenseDto) {
//        Expense expense=expenseRepository.findByDate(expenseDto.getDate());
        Expense expense= expenseRepository.findByDateAndTypeOfExpense(expenseDto.getDate(),expenseDto.getTypeOfExpense());
        if (expense==null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Date already exists");
        }

        if (expense.getCategory() != null && !expense.getCategory().isBlank()) {
            expense.setCategory(expense.getCategory()+" ,"+expenseDto.getCategory());
        }

//        if (expense.getTypeOfExpense() != null) {
//            expense.setTypeOfExpense(expenseDto.getTypeOfExpense());
//        }

        if (expenseDto.getAmount() != 0) {
            double amount=expense.getAmount();
            double total=amount+expenseDto.getAmount();
            expense.setAmount(total);

        }

        expenseRepository.save(expense);

    }

    @Override
    public void deleteData(String date, ExpenseCategory typeOfExpense) {
        expenseRepository.deleteByDateAndTypeOfExpense(date,typeOfExpense);

    }
}
