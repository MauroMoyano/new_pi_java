package interfaces.impl;

import dao.dto.ExpenseDto;
import entities.Expense;
import interfaces.ExpenseCalculator;

import java.util.List;

public class ExpenseCalculatorImpl implements ExpenseCalculator {
    @Override
    public double calculateExpense(ExpenseDto expense) {
        return expense.getAmount();
    }

    @Override
    public double calculateTotalExpense(List<ExpenseDto> expenses) {
        return expenses.stream()
                            .map(ExpenseDto::getAmount)
                            .reduce(0.0, Double::sum);
    }
}
