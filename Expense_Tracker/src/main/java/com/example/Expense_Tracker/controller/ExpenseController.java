package com.example.Expense_Tracker.controller;

import com.example.Expense_Tracker.dto.ExpenseCategory;
import com.example.Expense_Tracker.dto.ExpenseDto;
import com.example.Expense_Tracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
@CrossOrigin("*")

public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;
    @PostMapping("/add")
    public void addExpense(@RequestBody ExpenseDto expenseDto)
    {
        expenseService.addData(expenseDto);
    }
    @GetMapping("/view/datas")
    public List<ExpenseDto> getData()
    {
        return expenseService.getData();
    }
    @PutMapping("/update/amount")
    public void updateData(@RequestBody ExpenseDto expenseDto)
    {
        expenseService.updateExpense(expenseDto);
    }
    @DeleteMapping("/delete/date")
    public void deleteData(@RequestParam("date") String date, @RequestParam("typeOfExpense")ExpenseCategory typeOfExpense )
    {
        expenseService.deleteData(date,typeOfExpense);
    }
}
