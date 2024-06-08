package dao.impl;

import config.JdbcConfiguration;
import dao.ExpenseCategoryDao;
import dao.dto.ExpenseCategoryDto;
import entities.ExpenseCategory;
import exception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExpenseCategoryDaoImpl implements ExpenseCategoryDao {

    private static final String INSERT_INTO_CATEGORY = "INSERT INTO category (name) VALUES (?)";
    private static final String GET_CATEGORY_BY_NAME = "SELECT id, name FROM category WHERE name =?";
    private final Connection connection;

    public ExpenseCategoryDaoImpl() {
        this.connection = JdbcConfiguration.getDBConnection();
    }

    @Override
    public void insert(ExpenseCategoryDto expenseCategoryDto) {
        try(PreparedStatement statement = connection.prepareStatement(INSERT_INTO_CATEGORY)){
            int affectedRows;
            ExpenseCategory expenseCategory = mapDtoToExpenseCategory(expenseCategoryDto);

            statement.setString(1, expenseCategory.getName());
            affectedRows = statement.executeUpdate();

            if(affectedRows == 0){
                throw new DAOException("Error al insert category");
            }
        }catch (SQLException | DAOException e){
            e.printStackTrace();
        }
    }

    @Override
    public ExpenseCategoryDto getCategoryByName(String categoryName) {
        try(PreparedStatement statement = connection.prepareStatement(GET_CATEGORY_BY_NAME)){
            statement.setString(1, categoryName);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                return new ExpenseCategoryDto(resultSet.getInt("id"), resultSet.getString("name"));
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private ExpenseCategory mapDtoToExpenseCategory(ExpenseCategoryDto expenseCategoryDto){
        ExpenseCategory expenseCategory = new ExpenseCategory();
        expenseCategory.setName(expenseCategoryDto.getName());
        return expenseCategory;
    }
}
