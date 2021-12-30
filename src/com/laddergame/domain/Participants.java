package com.laddergame.domain;

import java.util.List;
import java.util.stream.Collectors;

import static com.laddergame.util.Parser.parseInput;

public class Participants {
    private final List<Participant> participants;

    private Participants(List<String> names) {
        participants = names.stream()
                .map(Participant::valueOf)
                .collect(Collectors.toList());
    }

    public static Participants valueOf(String namesString) {
        return new Participants(parseInput(namesString));
    }

    public int getParticipantNumber() {
        return this.participants.size();
    }

    public List<String> getParticipantsNames() {
        return this.participants.stream()
                .map(Participant::getName)
                .collect(Collectors.toList());
    }
}
