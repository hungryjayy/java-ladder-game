package com.laddergame.domain;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static com.laddergame.util.Parser.parseInput;

public class GameResult {
    private final Map<String, String> matchedGameResults;

    private GameResult(Map<String, String> gameResults) {
        this.matchedGameResults = gameResults;
    }

    public static GameResult valueOf(Participants participantsNamesString, Lines lines, String gameResultsString) {
        List<String> gameResults = parseInput(gameResultsString);
        Map<String, String> matchedGameResults = makeGameResults(participantsNamesString, lines, gameResults);
        return new GameResult(matchedGameResults);
    }

    private static Map<String, String> makeGameResults(
            Participants participants,
            Lines lines,
            List<String> gameResults
    ) {
        List<String> participantsNames = participants.getParticipantsNames();
        AtomicInteger index = new AtomicInteger();
        return participantsNames.stream()
                .collect(Collectors.toMap(
                        participantName -> participantName,
                        gameResult -> getGameResult(index.getAndIncrement(), lines, gameResults)
                ));
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

    public Map<String, String> getMatchedGameResults() {
        return matchedGameResults;
    }
}
