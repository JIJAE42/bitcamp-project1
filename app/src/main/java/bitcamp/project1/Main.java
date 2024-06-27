/*
 * This source file was generated by the Gradle 'init' task
 */
package bitcamp.project1;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        AccountBook accountBook = new AccountBook();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("1. 수입 추가");
            System.out.println("2. 지출 추가");
            System.out.println("3. 거래 내역 보기");
            System.out.println("4. 지출 내역 보기");
            System.out.println("5. 메모장");
            System.out.println("6. 종료");
            System.out.print("옵션을 선택하세요: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } catch (Exception e) {
                System.out.println("유효한 입력이 아닙니다.");
                scanner.nextLine(); // Consume newline
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("날짜 입력 (YYYY-MM-DD): ");
                    LocalDate incomeDate;
                    try {
                        incomeDate = LocalDate.parse(scanner.nextLine());
                    } catch (Exception e) {
                        System.out.println("유효한 날짜 형식이 아닙니다.");
                        continue;
                    }
                    System.out.print("금액 입력: ");
                    Long incomeAmount;
                    try {
                        incomeAmount = scanner.nextLong();
                        scanner.nextLine(); // Consume newline
                    } catch (Exception e) {
                        System.out.println("유효한 금액 형식이 아닙니다.");
                        scanner.nextLine(); // Consume newline
                        continue;
                    }
                    System.out.print("설명 입력: ");
                    String incomeDescription = scanner.nextLine();
                    accountBook.addTransaction(new Income(incomeDate, (long) incomeAmount, incomeDescription));
                    break;
                case 2:
                    System.out.print("날짜 입력 (YYYY-MM-DD): ");
                    LocalDate expenseDate;
                    try {
                        expenseDate = LocalDate.parse(scanner.nextLine());
                    } catch (Exception e) {
                        System.out.println("유효한 날짜 형식이 아닙니다.");
                        continue;
                    }
                    System.out.print("금액 입력: ");
                    long expenseAmount;
                    try {
                        expenseAmount = scanner.nextLong();
                        scanner.nextLine(); // Consume newline
                    } catch (Exception e) {
                        System.out.println("유효한 금액 형식이 아닙니다.");
                        scanner.nextLine(); // Consume newline
                        continue;
                    }
                    System.out.println("용도 선택:");
                    System.out.println("1. 주거");
                    System.out.println("2. 통신");
                    System.out.println("3. 교통");
                    System.out.println("4. 금융");
                    System.out.println("5. 식비");
                    System.out.println("6. 취미");
                    System.out.print("옵션을 선택하세요: ");
                    int categoryChoice;
                    try {
                        categoryChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                    } catch (Exception e) {
                        System.out.println("유효한 선택이 아닙니다.");
                        scanner.nextLine(); // Consume newline
                        continue;
                    }
                    Expense.Category category;
                    switch (categoryChoice) {
                        case 1:
                            category = Expense.Category.HOUSING;
                            break;
                        case 2:
                            category = Expense.Category.COMMUNICATION;
                            break;
                        case 3:
                            category = Expense.Category.TRANSPORTATION;
                            break;
                        case 4:
                            category = Expense.Category.FINANCE;
                            break;
                        case 5:
                            category = Expense.Category.FOOD;
                            break;
                        case 6:
                            category = Expense.Category.HOBBY;
                            break;
                        default:
                            System.out.println("유효한 선택이 아닙니다.");
                            continue;
                    }
                    System.out.print("설명 입력: ");
                    String expenseDescription = scanner.nextLine();
                    accountBook.addTransaction(new Expense(expenseDate, (long) expenseAmount, expenseDescription, category));
                    break;
                case 3:
                    System.out.println("1. 전체 거래 내역");
                    System.out.println("2. 수입 내역");
                    System.out.println("3. 지출 내역");
                    System.out.print("옵션을 선택하세요: ");

                    int transactionChoice;
                    try {
                        transactionChoice = scanner.nextInt();
                        scanner.nextLine();
                    } catch (Exception e) {
                        System.out.println("유효한 선택이 아닙니다.");
                        scanner.nextLine();
                        continue;
                    }

                    switch (transactionChoice) {
                        case 1:
                            accountBook.printAllTransactions();
                            break;
                        case 2:
                            accountBook.printIncomeTransactions();
                            break;
                        case 3:
                            accountBook.printExpenseTransactions();
                            break;
                        default:
                            System.out.println("유효한 선택이 아닙니다.");
                    }
                    break;
                case 4:
                    System.out.println("1. 전체내역");
                    System.out.println("   a. 용도별 지출 비중");
                    System.out.println("2. 용도별 지출 내역");
                    System.out.println("   a. 주거");
                    System.out.println("   b. 통신");
                    System.out.println("   c. 교통");
                    System.out.println("   d. 금융");
                    System.out.println("   e. 식비");
                    System.out.println("   f. 취미");
                    System.out.println("3. 기간별 지출 내역");
                    System.out.println("   a. 일별 지출 내역 (사용자가 날짜 지정)");
                    System.out.println("   b. 월별 지출 내역 (사용자가 날짜 지정)");
                    System.out.println("   c. 연도별 지출 내역 (사용자가 날짜 지정)");
                    System.out.println("   d. 전월 대비 지출 증감률");
                    System.out.print("옵션을 선택하세요: ");

                    int expenseChoice;
                    try {
                        expenseChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                    } catch (Exception e) {
                        System.out.println("유효한 선택이 아닙니다.");
                        scanner.nextLine(); // Consume newline
                        continue;
                    }

                    switch (expenseChoice) {
                        case 1:
                            accountBook.printAllTransactions();
                            // 용도별 지출 비중 출력 (추가 구현 필요)
                            break;
                        case 2:
                            System.out.println("용도별 지출 내역:");
                            System.out.println("1. 주거");
                            System.out.println("2. 통신");
                            System.out.println("3. 교통");
                            System.out.println("4. 금융");
                            System.out.println("5. 식비");
                            System.out.println("6. 취미");
                            System.out.print("옵션을 선택하세요: ");
                            int detailChoice;
                            try {
                                detailChoice = scanner.nextInt();
                                scanner.nextLine(); // Consume newline
                            } catch (Exception e) {
                                System.out.println("유효한 선택이 아닙니다.");
                                scanner.nextLine(); // Consume newline
                                continue;
                            }
                            switch (detailChoice) {
                                case 1:
                                    accountBook.printTransactionsByCategory(Expense.Category.HOUSING);
                                    break;
                                case 2:
                                    accountBook.printTransactionsByCategory(Expense.Category.COMMUNICATION);
                                    break;
                                case 3:
                                    accountBook.printTransactionsByCategory(Expense.Category.TRANSPORTATION);
                                    break;
                                case 4:
                                    accountBook.printTransactionsByCategory(Expense.Category.FINANCE);
                                    break;
                                case 5:
                                    accountBook.printTransactionsByCategory(Expense.Category.FOOD);
                                    break;
                                case 6:
                                    accountBook.printTransactionsByCategory(Expense.Category.HOBBY);
                                    break;
                                default:
                                    System.out.println("유효한 선택이 아닙니다.");
                            }
                            break;
                        case 3:
                            System.out.println("기간별 지출 내역:");
                            System.out.println("a. 일별 지출 내역 (사용자가 날짜 지정)");
                            System.out.println("b. 월별 지출 내역 (사용자가 날짜 지정)");
                            System.out.println("c. 연도별 지출 내역 (사용자가 날짜 지정)");
                            System.out.println("d. 전월 대비 지출 증감률");
                            System.out.print("옵션을 선택하세요: ");

                            String periodChoice = scanner.nextLine();

                            switch (periodChoice) {
                                case "a":
                                    System.out.print("날짜 입력 (YYYY-MM-DD): ");
                                    LocalDate dailyDate;
                                    try {
                                        dailyDate = LocalDate.parse(scanner.nextLine());
                                    } catch (Exception e) {
                                        System.out.println("유효한 날짜 형식이 아닙니다.");
                                        continue;
                                    }
                                    accountBook.printDailyExpenses(dailyDate);
                                    break;
                                case "b":
                                    System.out.print("날짜 입력 (YYYY-MM): ");
                                    YearMonth monthlyDate;
                                    try {
                                        monthlyDate = YearMonth.parse(scanner.nextLine());
                                    } catch (Exception e) {
                                        System.out.println("유효한 날짜 형식이 아닙니다.");
                                        continue;
                                    }
                                    accountBook.printMonthlyExpenses(monthlyDate);
                                    break;
                                case "c":
                                    System.out.print("연도 입력 (YYYY): ");
                                    int year;
                                    try {
                                        year = scanner.nextInt();
                                        scanner.nextLine(); // Consume newline
                                    } catch (Exception e) {
                                        System.out.println("유효한 연도 형식이 아닙니다.");
                                        scanner.nextLine(); // Consume newline
                                        continue;
                                    }
                                    accountBook.printYearlyExpenses(year);
                                    break;
                                case "d":
                                    System.out.print("이전 월 입력 (YYYY-MM): ");
                                    YearMonth previousMonth;
                                    try {
                                        previousMonth = YearMonth.parse(scanner.nextLine());
                                    } catch (Exception e) {
                                        System.out.println("유효한 날짜 형식이 아닙니다.");
                                        continue;
                                    }
                                    System.out.print("현재 월 입력 (YYYY-MM): ");
                                    YearMonth currentMonth;
                                    try {
                                        currentMonth = YearMonth.parse(scanner.nextLine());
                                    } catch (Exception e) {
                                        System.out.println("유효한 날짜 형식이 아닙니다.");
                                        continue;
                                    }
                                    accountBook.printExpenseChangeRate(previousMonth, currentMonth);
                                    break;
                                default:
                                    System.out.println("유효한 선택이 아닙니다.");
                            }
                            break;
                        default:
                            System.out.println("유효한 선택이 아닙니다.");
                    }
                    break;

                case 5:
                    boolean memoMenu = true;
                    while (memoMenu) {
                        System.out.println("메모장 메뉴");
                        System.out.println("1. 등록");
                        System.out.println("2. 목록");
                        System.out.println("3. 변경");
                        System.out.println("4. 삭제");
                        System.out.println("5. 메모장 나가기");
                        System.out.print("옵션을 선택하세요: ");

                        int memoOption;
                        try {
                            memoOption = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                        } catch (Exception e) {
                            System.out.println("유효한 입력이 아닙니다.");
                            scanner.nextLine(); // Consume newline
                            continue;
                        }

                        switch (memoOption) {
                            case 1:
                                Memo.addMemo(scanner);
                                break;
                            case 2:
                                Memo.listMemos();
                                break;
                            case 3:
                                Memo.editMemo(scanner);
                                break;
                            case 4:
                                Memo.deleteMemo(scanner);
                                break;
                            case 5:
                                memoMenu = false;
                                break;
                            default:
                                System.out.println("유효한 입력이 아닙니다.");
                        }
                    }
                    break;


                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("유효한 입력이 아닙니다.");
            }
        }

        scanner.close();
    }
}
