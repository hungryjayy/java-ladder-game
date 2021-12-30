package com.laddergame.domain;

import java.util.List;

public class LadderGame {
    private final Lines lines;
    private final Participants participants;
    private final GameResult gameResult;

    private LadderGame(int ladderHeight, String participantNamesString, String gameResultsString) {
        participants = Participants.valueOf(participantNamesString);
        lines = Lines.valueOf(participants.getParticipantNumber(), ladderHeight);
        gameResult = GameResult.valueOf(participants, lines, gameResultsString);
    }

    public static LadderGame valueOf(int ladderHeight, String participantNamesString, String gameResultsString) {
        return new LadderGame(ladderHeight, participantNamesString, gameResultsString);
    }

    public List<String> getParticipantsNames() {
        return participants.getParticipantsNames();
    }

    public Lines getLines() {
        return lines;
    }

    public GameResult getGameResult() { return gameResult; };
}
