package bitcamp.project1;

import java.time.LocalDate;

public class Expense extends Transaction {
    public enum Category {
        HOUSING, COMMUNICATION, TRANSPORTATION, FINANCE, FOOD, HOBBY
    }

    private Category category;

    public Expense(LocalDate date, long amount, String description, Category category) {
        super(date, amount, description);
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String getType() {
        return "지출";
    }

    @Override
    public String toString() {
        return "지출: " + amount + ", 날짜: " + date + ", 설명: " + description + ", 용도: " + category;
    }
}
