package interfaces;

import dao.dto.ExpenseDto;
import entities.Expense;

import java.util.List;

public interface ExpenseCalculator {
    double calculateExpense(ExpenseDto expense);
    double calculateTotalExpense(List<ExpenseDto> expenses);
}
