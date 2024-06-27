package bitcamp.project1;
import java.time.LocalDate;

public abstract class Transaction {
    protected LocalDate date;
    protected long amount;
    protected String description;

    public Transaction(LocalDate date, long amount, String description) {
        this.date = date;
        this.amount = amount;
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public long getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public abstract String getType();
}
