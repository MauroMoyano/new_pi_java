package entities;

import dao.dto.ExpenseCategoryDto;

import java.util.Date;

public class ExpenseCategory {

    private Integer id;
    private String name;

    public ExpenseCategory() {
    }

    public ExpenseCategory(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public ExpenseCategory(ExpenseCategoryDto expenseCategoryDto) {
        this.id = expenseCategoryDto.getId();
        this.name = expenseCategoryDto.getName();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
