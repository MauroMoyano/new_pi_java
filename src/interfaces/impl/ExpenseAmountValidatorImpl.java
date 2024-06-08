package interfaces.impl;

import exception.InvalidExpenseException;
import interfaces.ExpenseAmountValidator;

public class ExpenseAmountValidatorImpl implements ExpenseAmountValidator {
    @Override
    public boolean notValidateAmount(double amount) throws InvalidExpenseException {
        if (amount < 0) {
            throw new InvalidExpenseException("Amount must be positive");
        }
        return false;
    }
}
