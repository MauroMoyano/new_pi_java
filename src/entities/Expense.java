package entities;

public class Expense {
    private Integer id;
    private Double amount;
    private String date;
    private int categoryId;

    public Expense() {
    }

    public Expense(Integer id, Double amount, String date, int categoryId) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.categoryId = categoryId;
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

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", amount=" + amount +
                ", date='" + date + '\'' +
                ", category=" + categoryId +
                '}';
    }
}
