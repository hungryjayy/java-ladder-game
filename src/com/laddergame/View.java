package com.laddergame;

import java.util.List;
import java.util.Scanner;

public class View {
    static Scanner scanner = new Scanner(System.in);

    private enum DELIMITER {
        LADDER("-"),
        NO_LADDER(" "),
        VERTICAL_LINE("|")
        ;

        DELIMITER(String delimiter) {
            this.value = delimiter;
        }

        private final String value;
    }

    static public int inputParticipantNumber() {
        System.out.println("참여할 사람은 몇 명인가요?");
        return scanner.nextInt();
    }

    static public int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇인가요?");
        return scanner.nextInt();
    }

    static public void outputLadderGameResult(List<List<Boolean>> result) {
        result.forEach(View::outputRoundResult);
    }

    static private void outputRoundResult(List<Boolean> roundResult) {
        roundResult.forEach(hasLadder -> {
            System.out.print(DELIMITER.VERTICAL_LINE.value);
            String eachResult = hasLadder ? DELIMITER.LADDER.value : DELIMITER.NO_LADDER.value;
            System.out.print(eachResult);
        });
        System.out.println(DELIMITER.VERTICAL_LINE.value);
    }
}
