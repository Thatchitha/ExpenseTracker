package com.example.Expense_Tracker.repository;

import com.example.Expense_Tracker.dto.ExpenseCategory;
import com.example.Expense_Tracker.model.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface ExpenseRepository extends MongoRepository<Expense,String> {
    void deleteByDateAndTypeOfExpense(String date,ExpenseCategory typeOfExpense);
//    Expense findByDate(String date);
    Expense findByDateAndTypeOfExpense(String date, ExpenseCategory typeOfExpense);
}
