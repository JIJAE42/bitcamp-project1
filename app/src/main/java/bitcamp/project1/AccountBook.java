package bitcamp.project1;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class AccountBook {
    private List<Transaction> transactions;
    private long balance;

    public AccountBook() {
        this.transactions = new ArrayList<>();
        this.balance = 0;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        if (transaction instanceof Income) {
            balance += transaction.getAmount();
        } else if (transaction instanceof Expense) {
            balance -= transaction.getAmount();
        }
        System.out.println("현재 잔액: " + balance);
    }

    public void printAllTransactions() {
        System.out.println("전체 거래 내역:");
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

    public void printTransactionsByCategory(Expense.Category category) {
        System.out.println(category + " 내역:");
        for (Transaction transaction : transactions) {
            if (transaction instanceof Expense && ((Expense) transaction).getCategory() == category) {
                System.out.println(transaction);
            }
        }
    }

    public void printTransactionsByDate(LocalDate startDate, LocalDate endDate) {
        System.out.println(startDate + "부터 " + endDate + "까지의 지출 내역:");
        for (Transaction transaction : transactions) {
            if (transaction.getDate().compareTo(startDate) >= 0 && transaction.getDate().compareTo(endDate) <= 0) {
                System.out.println(transaction);
            }
        }
    }

    public void printDailyExpenses(LocalDate date) {
        System.out.println(date + "의 일별 지출 내역:");
        for (Transaction transaction : transactions) {
            if (transaction.getDate().equals(date)) {
                System.out.println(transaction);
            }
        }
    }

    public void printMonthlyExpenses(YearMonth yearMonth) {
        System.out.println(yearMonth + "의 월별 지출 내역:");
        for (Transaction transaction : transactions) {
            if (YearMonth.from(transaction.getDate()).equals(yearMonth)) {
                System.out.println(transaction);
            }
        }
    }

    public void printYearlyExpenses(int year) {
        System.out.println(year + "의 연도별 지출 내역:");
        for (Transaction transaction : transactions) {
            if (transaction.getDate().getYear() == year) {
                System.out.println(transaction);
            }
        }
    }

    public void printExpenseChangeRate(YearMonth previousMonth, YearMonth currentMonth) {
        long previousTotal = transactions.stream()
                .filter(t -> t instanceof Expense && YearMonth.from(t.getDate()).equals(previousMonth))
                .mapToLong(Transaction::getAmount).sum();

        long currentTotal = transactions.stream()
                .filter(t -> t instanceof Expense && YearMonth.from(t.getDate()).equals(currentMonth))
                .mapToLong(Transaction::getAmount).sum();

        long changeRate = (currentTotal - previousTotal) / previousTotal * 100;
        System.out.println(previousMonth + " 대비 " + currentMonth + "의 지출 증감률: " + String.format("%.2f", changeRate) + "%");
    }
}
