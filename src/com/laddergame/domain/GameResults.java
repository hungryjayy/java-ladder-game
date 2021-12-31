package com.laddergame.domain;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static com.laddergame.util.ExceptionMessages.GAME_RESULT_LOWERBOUND_EXCEPTION;
import static com.laddergame.util.ExceptionMessages.NOT_MATCHING_PARTICIPANT_GAME_RESULT_NUMBER_EXCEPTION;
import static com.laddergame.util.Parser.parseInput;

public class GameResults {
    private final List<GameResult> gameResults;

    private GameResults(List<GameResult> gameResults) {
        this.gameResults = gameResults;
    }

    public static GameResults valueOf(Participants participants, Lines lines, String gameResultsString) {
        List<String> gameResults = parseInput(gameResultsString);
        validateResults(participants, gameResults);
        List<GameResult> matchedGameResults = getGameResults(participants, lines, gameResults);
        return new GameResults(matchedGameResults);
    }

    private static List<GameResult> getGameResults(Participants participants, Lines lines, List<String> gameResults) {
        AtomicInteger index = new AtomicInteger();
        return participants
                .getParticipantsNames()
                .stream()
                .map(participantName -> GameResult.valueOf(index.getAndIncrement(), participantName, lines, gameResults))
                .collect(Collectors.toList());
    }

    public GameResult findByParticipantName(String targetParticipant) {
        return this.gameResults
                .stream()
                .filter(gameResult -> Objects.equals(gameResult.getParticipantName(), targetParticipant))
                .findFirst().orElse(null);
    }

    public List<GameResult> findAll() {
        return this.gameResults;
    }

    private static void validateResults(Participants participants, List<String> gameResults) {
        if(!matchesParticipantGameResultNumber(participants, gameResults)) {
            throw new IllegalArgumentException(NOT_MATCHING_PARTICIPANT_GAME_RESULT_NUMBER_EXCEPTION);
        }
        gameResults.forEach(GameResults::validateResult);
    }

    private static boolean matchesParticipantGameResultNumber(Participants participants, List<String> gameResults) {
        return participants.getParticipantNumber() == gameResults.size();
    }

    private static void validateResult(String gameResult) {
        if (gameResult.length() < RESULT_LOWERBOUND) throw new IllegalArgumentException(GAME_RESULT_LOWERBOUND_EXCEPTION);
    }

    private static final int RESULT_LOWERBOUND = 1;
}
