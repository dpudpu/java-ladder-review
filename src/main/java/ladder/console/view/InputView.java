package ladder.console.view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public String inputNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return scanner.nextLine();
    }

    public int inputHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.err.println("숫자만 입력 가능합니다.");
            return inputHeight();
        }
    }
}