package com.laddergame;

import com.laddergame.domain.LadderGame;
import com.laddergame.domain.Lines;
import com.laddergame.dto.ResultDto;

import java.util.List;

import static com.laddergame.view.View.*;

public class LadderGameApplication {
    public static void main(String[] args) {
        String ParticipantNames = inputParticipantName();
        int ladderHeight = inputLadderHeight();

        LadderGame ladderGame = LadderGame.valueOf(ladderHeight, ParticipantNames);
        Lines lines = ladderGame.getLines();
        List<String> participantNames = ladderGame.getParticipantsNames();
        ResultDto resultDto = ResultDto.from(lines);

        outputParticipantNames(participantNames);
        outputLadderGameResult(resultDto.getGameResult());
    }
}
