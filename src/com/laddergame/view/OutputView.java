package com.laddergame.view;

import java.util.List;

import static com.laddergame.util.ExceptionMessages.UNNECESSARY_INSTANCE_GENERATION_EXCEPTION;

public class OutputView {
    private OutputView() throws RuntimeException {
        throw new RuntimeException(UNNECESSARY_INSTANCE_GENERATION_EXCEPTION);
    }

    public static void outputLadderGameResult(List<List<Boolean>> lines, List<String> names, List<String> results) {
        System.out.println("사다리 결과\n");
        outputParticipantNames(names);
        lines.forEach(OutputView::outputLine);
        outputGameResult(results);
    }

    public static void outputParticipantResult(String result) {
        System.out.println(result);
        System.out.println();
    }

    public static void outputAllParticipantResults(List<String> names, List<String> results) {
        for(int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i) + " : " + results.get(i));
        }
        System.out.println();
    }

    private static void outputParticipantNames(List<String> names) {
        names.forEach(name -> System.out.printf("%6s", name));
        System.out.println();
    }

    private static void outputGameResult(List<String> results) {
        results.forEach(result -> System.out.printf("%6s", result));
        System.out.print("\n\n");
    }

    private static void outputLine(List<Boolean> line) {
        System.out.print(ViewDelimiter.LADDER_PADDING.value);
        line.forEach(hasLadder -> {
            System.out.print(ViewDelimiter.VERTICAL_LINE.value);
            String ladder = hasLadder ? ViewDelimiter.LADDER.value : ViewDelimiter.NO_LADDER.value;
            System.out.print(ladder);
        });
        System.out.println(ViewDelimiter.VERTICAL_LINE.value);
    }
}
