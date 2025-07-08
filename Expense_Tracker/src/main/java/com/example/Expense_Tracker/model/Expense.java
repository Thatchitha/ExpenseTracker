package com.example.Expense_Tracker.model;

import com.example.Expense_Tracker.dto.ExpenseCategory;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "expeseReports")
public class Expense {
    @Id
    private String id;
    private String date;
    private ExpenseCategory typeOfExpense;
    private String category;
    private double amount;

    public Expense(String id, String date, ExpenseCategory typeOfExpense, String category, double amount) {
        this.id = id;
        this.date = date;
        this.typeOfExpense = typeOfExpense;
        this.category = category;
        this.amount = amount;
    }

    public Expense() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ExpenseCategory getTypeOfExpense() {
        return typeOfExpense;
    }

    public void setTypeOfExpense(ExpenseCategory typeOfExpense) {
        this.typeOfExpense = typeOfExpense;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
