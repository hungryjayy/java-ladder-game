package com.laddergame.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Boolean> hasLadders;

    private Line(List<Boolean> hasLadders) {
        this.hasLadders = hasLadders;
    }

    public static Line valueOf(int participantNumber) {
        return new Line(addLadder(participantNumber));
    }

    public List<Boolean> getHasLadders() {
        return hasLadders;
    }

    private static List<Boolean> addLadder(int participantNumber) {
        List<Boolean> hasLadders = new ArrayList<>();
        for (int i = 0; i < participantNumber - 1; i++) {
            hasLadders.add(isLadderAddable(hasLadders));
        }
        return hasLadders;
    }

    private static boolean isLadderAddable(List<Boolean> hasLadders) {
        return !hasPreviousLadder(hasLadders) && RandomNumber.exceedsThreshold();
    }

    private static boolean hasPreviousLadder(List<Boolean> hasLadders) {
        if (hasLadders.size() == 0) return false;
        return hasLadders.get(hasLadders.size() - 1);
    }
}
