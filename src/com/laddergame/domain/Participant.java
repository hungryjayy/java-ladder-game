package com.laddergame.domain;

import static com.laddergame.util.ExceptionMessages.NAME_LENGTH_LOWERBOUND_EXCEPTION;
import static com.laddergame.util.ExceptionMessages.NAME_LENGTH_UPPERBOUND_EXCEPTION;

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
            throw new IllegalArgumentException(NAME_LENGTH_UPPERBOUND_EXCEPTION);
        }
        if (name.length() < NAME_LENGTH_LOWERBOUND) {
            throw new IllegalArgumentException(NAME_LENGTH_LOWERBOUND_EXCEPTION);
        }
    }

    private static final int NAME_LENGTH_UPPERBOUND = 5;
    private static final int NAME_LENGTH_LOWERBOUND = 1;
}
