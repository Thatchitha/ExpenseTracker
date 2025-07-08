package com.example.Expense_Tracker.dto;

public class ExpenseDto {
    private String date;
    private ExpenseCategory typeOfExpense;
    private String category;
    private double amount;

    public ExpenseDto(String date, ExpenseCategory typeOfExpense, String category, double amount) {
        this.date = date;
        this.typeOfExpense = typeOfExpense;
        this.category = category;
        this.amount = amount;
    }

    public ExpenseDto() {
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
