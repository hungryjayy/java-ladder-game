package com.laddergame.view;

import java.util.List;
import java.util.Scanner;

public class View {
    private final static Scanner scanner = new Scanner(System.in);

    private View() throws RuntimeException {
        throw new RuntimeException("Unnecessary instance generation");
    }

    private enum DELIMITER {
        LADDER("-----"),
        NO_LADDER("     "),
        VERTICAL_LINE("|"),
        LADDER_PADDING("    ")
        ;

        DELIMITER(String delimiter) {
            this.value = delimiter;
        }

        private final String value;
    }

    public static String inputParticipantName() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return scanner.nextLine();
    }

    public static int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇인가요?");
        return scanner.nextInt();
    }

    public static void outputParticipantNames(List<String> names) {
        names.forEach(name -> System.out.printf("%6s", name));
        System.out.println();
    }

    public static void outputLadderGameResult(List<List<Boolean>> result) {
        result.forEach(View::outputRoundResult);
    }

    private static void outputRoundResult(List<Boolean> roundResult) {
        System.out.print(DELIMITER.LADDER_PADDING.value);
        roundResult.forEach(hasLadder -> {
            System.out.print(DELIMITER.VERTICAL_LINE.value);
            String ladder = hasLadder ? DELIMITER.LADDER.value : DELIMITER.NO_LADDER.value;
            System.out.print(ladder);
        });
        System.out.println(DELIMITER.VERTICAL_LINE.value);
    }
}
