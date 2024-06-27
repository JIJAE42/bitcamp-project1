package bitcamp.project1;

import java.util.Scanner;

public class Main {

        private static Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            AccountBook incomeAccountBook = new AccountBook();
            AccountBook expenseAccountBook = new AccountBook();

            while (true) {
                System.out.println("메뉴를 선택하세요:");
                System.out.println("1. 수입");
                System.out.println("2. 지출");
                System.out.println("3. 끝");

                int mainChoice = scanner.nextInt();
                scanner.nextLine(); // 개행 문자 소비

                switch (mainChoice) {
                    case 1:
                        manageTransactions(incomeAccountBook, "수입");
                        break;
                    case 2:
                        manageTransactions(expenseAccountBook, "지출");
                        break;
                    case 3:
                        System.out.println("프로그램을 종료합니다.");
                        return;
                    default:
                        System.out.println("잘못된 입력입니다. 다시 시도하세요.");
                }
            }
        }

        private static void manageTransactions(AccountBook accountBook, String type) {
            while (true) {
                System.out.println(type + " 메뉴를 선택하세요:");
                System.out.println("1. 등록");
                System.out.println("2. 목록");
                System.out.println("3. 변경");
                System.out.println("4. 삭제");
                System.out.println("5. 돌아가기");

                int choice = scanner.nextInt();
                scanner.nextLine(); // 개행 문자 소비

                switch (choice) {
                    case 1:
                        addTransaction(accountBook, type);
                        break;
                    case 2:
                        accountBook.listTransactions();
                        break;
                    case 3:
                        updateTransaction(accountBook);
                        break;
                    case 4:
                        deleteTransaction(accountBook);
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("잘못된 입력입니다. 다시 시도하세요.");
                }
            }
        }

        private static void addTransaction(AccountBook accountBook, String type) {
            System.out.println(type + " 거래를 등록합니다.");

            System.out.print("거래날짜: ");
            String date = scanner.nextLine();

            System.out.print("용도 (1: 주거, 2: 통신, 3: 교통, 4: 금융, 5: 식비, 6: 취미): ");
            int purposeChoice = scanner.nextInt();
            scanner.nextLine(); // 개행 문자 소비

            System.out.print("설명: ");
            String description = scanner.nextLine();

            System.out.print("금액: ");
            int amount = scanner.nextInt();
            scanner.nextLine(); // 개행 문자 소비

            accountBook.addTransaction(date, purposeChoice, description, amount);
        }

        private static void updateTransaction(AccountBook accountBook) {
            System.out.print("변경할 거래 번호: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // 개행 문자 소비

            System.out.print("거래날짜 (변경하지 않으려면 빈칸): ");
            String date = scanner.nextLine();

            System.out.print("용도 (1: 주거, 2: 통신, 3: 교통, 4: 금융, 5: 식비, 6: 취미, 변경하지 않으려면 0): ");
            int purposeChoice = scanner.nextInt();
            scanner.nextLine(); // 개행 문자 소비

            System.out.print("설명 (변경하지 않으려면 빈칸): ");
            String description = scanner.nextLine();

            System.out.print("금액 (변경하지 않으려면 0): ");
            int amount = scanner.nextInt();
            scanner.nextLine(); // 개행 문자 소비

            accountBook.updateTransaction(id, date, purposeChoice, description, amount);
        }

        private static void deleteTransaction(AccountBook accountBook) {
            System.out.print("삭제할 거래 번호: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // 개행 문자 소비

            accountBook.deleteTransaction(id);
        }
    }

