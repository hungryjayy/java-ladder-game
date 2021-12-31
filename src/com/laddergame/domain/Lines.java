package com.laddergame.domain;

import java.util.ArrayList;
import java.util.List;

import static com.laddergame.util.ExceptionMessages.LADDER_HEIGHT_LOWERBOUND_EXCEPTION;

public class Lines {
    private final List<Line> lines;

    private Lines(List<Line> lines) {
        this.lines = lines;
    }

    public static Lines valueOf(int participantNumber, int height) {
        validateHeight(height);
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(Line.valueOf(participantNumber));
        }
        return new Lines(lines);
    }

    private static void validateHeight(int height) throws IllegalArgumentException {
        if (height < HEIGHT_LOWERBOUND) throw new IllegalArgumentException(LADDER_HEIGHT_LOWERBOUND_EXCEPTION);
    }

    public List<Line> getLines() {
        return lines;
    }

    private static final int HEIGHT_LOWERBOUND = 1;
}
