package bitcamp.project1;

import java.util.ArrayList;

public class AccountBook {

        private ArrayList<Transaction> transactions = new ArrayList<>();
        private static int transactionIdCounter = 1;

        public void addTransaction(String date, int purposeChoice, String description, int amount) {
            String purpose = getPurpose(purposeChoice);
            transactions.add(new Transaction(transactionIdCounter++, date, purpose, description, amount));
            System.out.println("거래가 등록되었습니다.");
        }

        public void listTransactions() {
            if (transactions.isEmpty()) {
                System.out.println("등록된 거래가 없습니다.");
            } else {
                System.out.println("번호 거래날짜 용도 설명 금액");
                for (Transaction transaction : transactions) {
                    System.out.println(transaction);
                }
            }
        }

        public void updateTransaction(int id, String date, int purposeChoice, String description, int amount) {
            Transaction transaction = findTransactionById(id);

            if (transaction == null) {
                System.out.println("해당 번호의 거래가 없습니다.");
                return;
            }

            if (!date.isEmpty()) {
                transaction.date = date;
            }

            if (purposeChoice > 0) {
                transaction.purpose = getPurpose(purposeChoice);
            }

            if (!description.isEmpty()) {
                transaction.description = description;
            }

            if (amount > 0) {
                transaction.amount = amount;
            }

            System.out.println("거래가 변경되었습니다.");
        }

        public void deleteTransaction(int id) {
            Transaction transaction = findTransactionById(id);

            if (transaction == null) {
                System.out.println("해당 번호의 거래가 없습니다.");
                return;
            }

            transactions.remove(transaction);
            System.out.println("거래가 삭제되었습니다.");
        }

        private Transaction findTransactionById(int id) {
            for (Transaction transaction : transactions) {
                if (transaction.id == id) {
                    return transaction;
                }
            }
            return null;
        }

        private String getPurpose(int choice) {
            switch (choice) {
                case 1: return "주거";
                case 2: return "통신";
                case 3: return "교통";
                case 4: return "금융";
                case 5: return "식비";
                case 6: return "취미";
                default: return "기타";
            }
        }
    }
