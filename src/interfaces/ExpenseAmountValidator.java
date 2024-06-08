package interfaces;

import exception.InvalidExpenseException;

@FunctionalInterface
public interface ExpenseAmountValidator {
    boolean notValidateAmount(double amount) throws InvalidExpenseException;
}
