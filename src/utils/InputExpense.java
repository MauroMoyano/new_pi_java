package utils;

import config.JdbcConfiguration;
import dao.ExpenseCategoryDao;
import dao.ExpenseDao;
import dao.dto.ExpenseCategoryDto;
import dao.impl.ExpenseCategoryDaoImpl;
import dao.impl.ExpenseDaoImpl;
import dao.dto.ExpenseDto;
import entities.ExpenseCategory;
import exception.InvalidExpenseException;
import interfaces.ExpenseAmountValidator;
import interfaces.impl.ExpenseAmountValidatorImpl;

import java.sql.Connection;
import java.util.Scanner;

public class InputExpense {
    public static void input() throws InvalidExpenseException {
        Connection conn = JdbcConfiguration.getDBConnection();
        double amount;
        ExpenseDto expenseDto;
        ExpenseDao expenseDao = new ExpenseDaoImpl(conn);
        ExpenseCategoryDao expenseCategoryDao = new ExpenseCategoryDaoImpl();
        Scanner scanner = new Scanner(System.in);
        ExpenseAmountValidator expenseAmountValidator = new ExpenseAmountValidatorImpl();
        ExpenseCategoryDto expenseCategoryDto = new ExpenseCategoryDto();
        ExpenseCategory expenseCategory = new ExpenseCategory();



        System.out.print("Ingrese el monto del gasto: ");
        amount = scanner.nextDouble();

        if (!expenseAmountValidator.notValidateAmount(amount)) System.out.println("El monto es valido");

        scanner.nextLine();//limpieza de buffer
        System.out.print("Ingrese la categoria del gasto: ");
        String categoryName = scanner.nextLine().toLowerCase().trim();

        expenseCategoryDto.setName(categoryName);
        expenseCategoryDao.insert(expenseCategoryDto);

        System.out.print("Ingrese la fecha del gasto: (dd/mm/yyyy): ");
        String date = scanner.nextLine().trim();


        //carga de datos
        expenseDto = new ExpenseDto( amount, date, expenseCategoryDao.getCategoryByName(categoryName).getId());
            expenseDao.insert(expenseDto);

    }
}