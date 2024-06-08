package interfaces;

import java.util.Date;

public interface Expense {
    public String getAmount();
    public Date getDate();
    public String getCategory();
    public String getTotalCategory();
    public String getDescription();
}
