package dao.dto;

public class ExpenseDto {

    private Double amount;
    private String date;
    private int categoryId;
    private int id;

    public ExpenseDto() {
    }

    public ExpenseDto(Double amount, String date, int categoryId) {
        this.amount = amount;
        this.date = date;
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
                ", amount=" + amount +
                ", date='" + date + '\'' +
                ", categoryId=" + categoryId +
                '}';
    }
}
