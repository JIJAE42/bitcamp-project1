package bitcamp.project1;
import java.time.LocalDate;

public class Income extends Transaction {

    public Income(LocalDate date, long amount, String description) {
        super(date, amount, description);
    }

    @Override
    public String getType() {
        return "수입";
    }

    @Override
    public String toString() {
        return "수입: " + amount + ", 날짜: " + date + ", 설명: " + description;
    }
}
