package dao.dto;

import java.util.Date;

public class ExpenseCategoryDto {

    private Integer id;
    private String name;

    public ExpenseCategoryDto() {
    }

    public ExpenseCategoryDto(Integer id, String name) {
        this.id = id;
        this.name = name;
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
