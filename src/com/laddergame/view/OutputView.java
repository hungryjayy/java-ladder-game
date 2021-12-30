package com.laddergame.view;

import java.util.List;

public class OutputView {
    private OutputView() throws RuntimeException {
        throw new RuntimeException("Unnecessary instance generation");
    }

    public static void outputLadderGameResult(List<List<Boolean>> lines, List<String> names, List<String> results) {
        System.out.println("사다리 결과\n");
        outputParticipantNames(names);
        lines.forEach(OutputView::outputLine);
        outputGameResult(results);
    }

    public static void outputParticipantResult(String result) {
        System.out.println(result);
    }

    private static void outputParticipantNames(List<String> names) {
        names.forEach(name -> System.out.printf("%6s", name));
        System.out.println();
    }

    private static void outputGameResult(List<String> results) {
        results.forEach(result -> System.out.printf("%6s", result));
        System.out.println();
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
