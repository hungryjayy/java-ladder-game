package com.laddergame;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private final List<List<Boolean>> results = new ArrayList<>();

    public int participantNumber;

    public int ladderHeight;

    public LadderGame(int participantNumber, int ladderHeight) {
        this.participantNumber = participantNumber;
        this.ladderHeight = ladderHeight;
    }

    public List<List<Boolean>> startGame() {
        for(int i = 0; i < ladderHeight; i++) {
            List<Boolean> roundResults = startEachRound();
            results.add(roundResults);
        }
        return results;
    }

    private List<Boolean> startEachRound() {
        List<Boolean> results = new ArrayList<>();
        for(int i = 0; i < participantNumber - 1; i++) {
            results.add(hasLadderOrNot());
        }
        return results;
    }

    private boolean hasLadderOrNot() {
        return RandomNumberUtil.exceedsThreshold();
    }
}
