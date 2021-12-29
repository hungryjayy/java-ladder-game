package com.laddergame;

import java.util.List;

import static com.laddergame.View.*;

public class LadderGameApplication {

    public static void main(String[] args) {
        int participantNumber = inputParticipantNumber();
        int ladderHeight = inputLadderHeight();
        List<List<Boolean>> result = new LadderGame(participantNumber, ladderHeight).startGame();
        outputLadderGameResult(result);
    }
}
