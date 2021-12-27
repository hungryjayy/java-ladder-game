package com.laddergame;

import java.util.ArrayList;

import static com.laddergame.View.*;

public class LadderGameApplication {

    public static void main(String[] args) {
        int participantNumber = inputParticipantNumber();
        int ladderHeight = inputLadderHeight();
        ArrayList<ArrayList<Boolean>> result = new LadderGame(participantNumber, ladderHeight).startGame();
        outputLadderGameResult(result);
    }
}
