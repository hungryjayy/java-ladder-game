package com.laddergame.domain;

import java.util.ArrayList;
import java.util.List;

public class Lines {
    private final List<Line> lines;

    private Lines(List<Line> lines) {
        this.lines = lines;
    }

    public static Lines valueOf(int participantNumber, int height) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(Line.valueOf(participantNumber));
        }
        return new Lines(lines);
    }

    public List<Line> getLines() {
        return lines;
    }
}
