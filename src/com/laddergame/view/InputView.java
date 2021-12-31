package com.laddergame.view;

import java.util.Scanner;

import static com.laddergame.util.ExceptionMessages.UNNECESSARY_INSTANCE_GENERATION_EXCEPTION;

public class InputView {
    private InputView() throws RuntimeException {
        throw new RuntimeException(UNNECESSARY_INSTANCE_GENERATION_EXCEPTION);
    }

    private final static Scanner scanner = new Scanner(System.in);

    public static String inputParticipantName() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return scanner.nextLine();
    }

    public static String inputGameResult() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return scanner.nextLine();
    }

    public static int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇인가요?");
        return scanner.nextInt();
    }

    public static String inputToShowParticipantResult() {
        System.out.println("결과를 보고 싶은 사람은?");
        return scanner.next();
    }

    public static String APPLICATION_EXIT = "춘식이";
    public static String EVERY_PARTICIPANT = "all";
}
