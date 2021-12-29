package com.laddergame.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Participants {
    private final List<Participant> participants;

    private Participants(List<String> names) {
        participants = names.stream()
                .map(Participant::valueOf)
                .collect(Collectors.toList());
    }

    public static Participants valueOf(String namesString) {
        return new Participants(parseName(namesString));
    }

    public int getParticipantNumber() {
        return this.participants.size();
    }

    public List<String> getParticipantsNames() {
        return this.participants.stream()
                .map(Participant::getName)
                .collect(Collectors.toList());
    }

    private static List<String> parseName(String namesString) {
        return List.of(namesString.split(PARTICIPANTS_NAME_DELIMITER));
    }

    private static final String PARTICIPANTS_NAME_DELIMITER = ",";
}
