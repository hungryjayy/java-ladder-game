package com.laddergame.domain;

import java.util.List;
import java.util.stream.Collectors;

public class GameResult {
    private final String participantName;
    private final String result;

    private GameResult(String participantName, String result) {
        this.participantName = participantName;
        this.result = result;
    }

    public static GameResult valueOf(int index, String participantName, Lines lines, List<String> results) {
        String result = getGameResult(index, lines, results);
        return new GameResult(participantName, result);
    }

    private static String getGameResult(int currentIndex, Lines lines, List<String> gameResults) {
        List<List<Boolean>> listedLines = lines
                .getLines()
                .stream()
                .map(Line::getHasLadders)
                .collect(Collectors.toList());

        for (int i = 0; i < listedLines.size(); i++) {
            currentIndex = goDown(i, currentIndex, listedLines);
        }

        return gameResults.get(currentIndex);
    }

    private static int goDown(int y, int x, List<List<Boolean>> lines) {
        List<Boolean> line = lines.get(y);
        if (x == 0) return line.get(x) ? x + 1 : x;
        if (x == line.size()) return line.get(x - 1) ? x - 1 : x;
        if (line.get(x - 1)) return x - 1;
        if (line.get(x)) return x + 1;
        return x;
    }

    public String getParticipantName() {
        return participantName;
    }

    public String getResult() {
        return result;
    }
}
