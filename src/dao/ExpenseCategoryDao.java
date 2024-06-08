package dao;

import dao.dto.ExpenseCategoryDto;

public interface ExpenseCategoryDao {
    void insert(ExpenseCategoryDto expenseCategoryDto);
    ExpenseCategoryDto getCategoryByName(String categoryName);
}
