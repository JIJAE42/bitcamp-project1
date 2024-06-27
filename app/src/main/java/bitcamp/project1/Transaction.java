package bitcamp.project1;

public class Transaction {
        int id;
        String date;
        String purpose;
        String description;
        int amount;

        public Transaction(int id, String date, String purpose, String description, int amount) {
            this.id = id;
            this.date = date;
            this.purpose = purpose;
            this.description = description;
            this.amount = amount;
        }

        @Override
        public String toString() {
            return String.format("%d %s %s %s %d원", id, date, purpose, description, amount);
        }
    }
