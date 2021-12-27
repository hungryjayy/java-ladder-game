package com.laddergame;

import java.util.ArrayList;
import java.util.Random;

public class LadderGame {
    private final ArrayList<ArrayList<Boolean>> results = new ArrayList<>();

    public int participantNumber;

    public int ladderHeight;

    public LadderGame(int participantNumber, int ladderHeight) {
        this.participantNumber = participantNumber;
        this.ladderHeight = ladderHeight;
    }

    public ArrayList<ArrayList<Boolean>> startGame() {
        Random random = new Random();
        for(int i = 0; i < ladderHeight; i++) {
            ArrayList<Boolean> roundResults = startEachRound(random);
            results.add(roundResults);
        }
        return results;
    }

    private ArrayList<Boolean> startEachRound(Random random) {
        ArrayList<Boolean> results = new ArrayList<>();
        for(int i = 0; i < participantNumber - 1; i++) {
            int randomNumber = random.nextInt(RANDOM_NUMBER_UPPER_BOUND);
            boolean result = randomNumber < RANDOM_NUMBER_UPPER_BOUND / 2;
            results.add(result);
        }
        return results;
    }

    static int RANDOM_NUMBER_UPPER_BOUND = 10;
}
