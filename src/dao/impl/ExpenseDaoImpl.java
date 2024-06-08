package dao.impl;

import dao.ExpenseDao;
import dao.dto.ExpenseDto;
import entities.Expense;
import exception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDaoImpl implements ExpenseDao {

    private static final String INSERT_INTO_EXPENSE = "INSERT INTO expense (amount, category_id, date) VALUES (?, ?, ?)";
    private static final String GET_ALL_EXPENSES = "SELECT id, amount, date, category_id FROM expense";
    private final Connection connection;

    public ExpenseDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(ExpenseDto expenseDto) {
        try(PreparedStatement statement = connection.prepareStatement(INSERT_INTO_EXPENSE)){
            statement.setDouble(1, expenseDto.getAmount());
            statement.setInt(2, expenseDto.getCategoryId());
            statement.setString(3, expenseDto.getDate());
            int affectedrows = statement.executeUpdate();

            if(affectedrows == 0){
                throw new DAOException("No se pudo insertar el gasto");
            }

        }catch (SQLException | DAOException e){
            e.printStackTrace();
        }
    }

    private Expense mapDtoToExpense(ExpenseDto expenseDto){
        Expense expense = new Expense();
        expense.setId(expenseDto.getId());
        expense.setAmount(expenseDto.getAmount());
        expense.setCategoryId(expenseDto.getCategoryId());
        expense.setDate(expenseDto.getDate());
        return expense;
    }

    @Override
    public List<ExpenseDto> getAll() {
        List<ExpenseDto> expenseList = null;
        try (PreparedStatement statement = connection.prepareStatement(GET_ALL_EXPENSES)) {
            ResultSet resultSet = statement.executeQuery();
            expenseList = new ArrayList<>();

            while (resultSet.next()) {
                expenseList.add(mapResultSetToExpenseDto(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return expenseList;
    }

    private ExpenseDto mapResultSetToExpenseDto(ResultSet resultSet) throws SQLException {
        ExpenseDto expenseDto = new ExpenseDto();
        expenseDto.setId(resultSet.getInt("id"));
        expenseDto.setAmount(resultSet.getDouble("amount"));
        expenseDto.setCategoryId(resultSet.getInt("category_id"));
        expenseDto.setDate(resultSet.getString("date"));
        return expenseDto;
    }

    @Override
    public void update(ExpenseDto expenseDto) {

    }

    @Override
    public void delete(Integer id) {

    }
}
