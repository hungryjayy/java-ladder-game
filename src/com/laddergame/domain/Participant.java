package com.laddergame.domain;

public class Participant {
    private final String name;

    private Participant(String name) {
        this.name = name;
    }

    public static Participant valueOf(String name) {
        validateName(name);
        return new Participant(name);
    }

    public String getName() {
        return this.name;
    }

    private static void validateName(String name) throws IllegalArgumentException {
        if (name.length() > NAME_LENGTH_UPPERBOUND) {
            throw new IllegalArgumentException("Name length should not exceed 5");
        }
    }

    private static final int NAME_LENGTH_UPPERBOUND = 5;
}
