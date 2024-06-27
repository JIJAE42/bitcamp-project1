package bitcamp.project1;

import java.util.Scanner;
import java.util.ArrayList;

public class Memo {

    private static ArrayList<String> memoList = new ArrayList<>();

    static void addMemo(Scanner scanner) {
        System.out.print("추가할 메모를 입력하세요: ");
        String memo = scanner.nextLine();
        memoList.add(memo);
        System.out.println("메모가 추가되었습니다.");
    }

    static void listMemos() {
        if (memoList.isEmpty()) {
            System.out.println("메모가 없습니다.");
        } else {
            System.out.println("메모 리스트:");
            for (int i = 0; i < memoList.size(); i++) {
                System.out.println((i + 1) + ". " + memoList.get(i));
            }
        }
    }

    static void editMemo(Scanner scanner) {
        System.out.print("변경할 메모의 번호를 입력하세요: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (index <= 0 || index > memoList.size()) {
            System.out.println("유효하지 않은 번호입니다.");
            return;
        }

        System.out.print("수정할 내용을 입력하세요: ");
        String updatedMemo = scanner.nextLine();
        memoList.set(index - 1, updatedMemo);
        System.out.println("메모가 변경되었습니다.");
    }

    static void deleteMemo(Scanner scanner) {
        System.out.print("삭제할 메모의 번호를 입력하세요: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (index <= 0 || index > memoList.size()) {
            System.out.println("유효하지 않은 번호입니다.");
            return;
        }

        memoList.remove(index - 1);
        System.out.println("메모가 삭제되었습니다.");
    }

}
