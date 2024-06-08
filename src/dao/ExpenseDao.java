package dao;

import dao.dto.ExpenseDto;

import java.util.List;


public interface ExpenseDao {
    void insert(ExpenseDto expenseDto);
    List<ExpenseDto> getAll();
    void update(ExpenseDto expenseDto);
    void delete(Integer id);
}
