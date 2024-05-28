package entities;

import java.util.Date;

public class ExpenseCategory {

    private Integer id;
    private Double amount;
    private String date;
    private ExpenseCategory category;

    public ExpenseCategory() {
    }

    public ExpenseCategory(Integer id, Double amount, String date, ExpenseCategory category) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ExpenseCategory getCategory() {
        return category;
    }

    public void setCategory(ExpenseCategory category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "ExpenseCategory{" +
                "id=" + id +
                ", amount=" + amount +
                ", date='" + date + '\'' +
                ", category=" + category +
                '}';
    }
}
