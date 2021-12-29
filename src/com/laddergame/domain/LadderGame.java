package com.laddergame.domain;

import java.util.List;

public class LadderGame {
    private final Lines lines;
    private final Participants participants;

    private LadderGame(int ladderHeight, String participantNamesString) {
        participants = Participants.valueOf(participantNamesString);
        lines = Lines.valueOf(participants.getParticipantNumber(), ladderHeight);
    }

    public static LadderGame valueOf(int ladderHeight, String participantNamesString) {
        return new LadderGame(ladderHeight, participantNamesString);
    }

    public List<String> getParticipantsNames() {
        return participants.getParticipantsNames();
    }

    public Lines getLines() {
        return lines;
    }
}
