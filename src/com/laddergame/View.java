package com.laddergame;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
    static Scanner scanner = new Scanner(System.in);

    static String LADDER_DELIMITER = "-";
    
    static String EMPTY_STRING = " ";
    
    static String VERTICAL_LINE = "|";

    static public int inputParticipantNumber() {
        System.out.println("참여할 사람은 몇 명인가요?");
        return scanner.nextInt();
    }

    static public int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇인가요?");
        return scanner.nextInt();
    }

    static public void outputLadderGameResult(ArrayList<ArrayList<Boolean>> result) {
        result.forEach(View::outputRoundResult);
    }

    static private void outputRoundResult(ArrayList<Boolean> roundResult) {
        roundResult.forEach(hasLadder -> {
            System.out.print(VERTICAL_LINE);
            String eachResult = hasLadder ? LADDER_DELIMITER : EMPTY_STRING;
            System.out.print(eachResult);
        });
        System.out.println(VERTICAL_LINE);
    }
}
