import config.JdbcConfiguration;
import dao.ExpenseDao;
import dao.dto.ExpenseDto;
import dao.impl.ExpenseDaoImpl;
import exception.InvalidExpenseException;
import interfaces.ExpenseCalculator;
import interfaces.impl.ExpenseCalculatorImpl;
import utils.ExpenseValidateAnswer;
import utils.InputExpense;
import utils.Utilities;

import java.sql.Connection;
import java.util.*;

public class Main {

    public static void main(String[] args) throws InvalidExpenseException {


        Connection conn = JdbcConfiguration.getDBConnection();
        Scanner scanner = new Scanner(System.in);
        boolean correctAnswer = true;
        String answer = "";
        ExpenseDao expenseDao = new ExpenseDaoImpl(conn);
        Map<String, Integer> countCategoryMap = new HashMap<>();

        ExpenseCalculator expenseCalculator = new ExpenseCalculatorImpl();

            System.out.println("Desea ingresar un gasto? Respuesta esperada SI/NO: ");
            answer = scanner.nextLine().toUpperCase().trim();

        correctAnswer = ExpenseValidateAnswer.validateAnswer(answer);

        while(correctAnswer) {
            InputExpense.input();

            System.out.println("Desea ingresar un gasto? Respuesta esperada SI/NO: ");
            answer = scanner.nextLine().toUpperCase().trim();
            correctAnswer = ExpenseValidateAnswer.validateAnswer(answer);
        }

        List<ExpenseDto> expenses = expenseDao.getAll();

        System.out.println("Total de gastos registrados: " + expenses.size());

        System.out.println("Total de gastos ingresados: " + expenseCalculator.calculateTotalExpense(expenses));

        System.out.println("TOP 3 DE GASTOS INGRESADOS");
        List<Double> top3 = expenses.stream()
                .map(ExpenseDto::getAmount)
                .limit(3)
                .sorted(Comparator.reverseOrder())
                .toList();

        top3.forEach(System.out::println);

        System.out.println("CONTADOR POR CATEGORIA: " );
        countCategoryMap.forEach( (category, categoryCount) -> System.out.println(category + ": " + categoryCount));

        System.out.println("Detalles de gastos ingresados");
        Utilities.printElements(expenses);
        System.out.println("Detalles de gastos ingresados 2da impresión");
        expenses.forEach(System.out::println);

    }
}