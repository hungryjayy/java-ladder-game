package com.laddergame;

import com.laddergame.domain.GameResults;
import com.laddergame.domain.LadderGame;
import com.laddergame.domain.Lines;
import com.laddergame.dto.LinesDto;
import com.laddergame.dto.GameResultDto;

import java.util.List;
import java.util.Objects;

import static com.laddergame.util.Parser.parseInput;
import static com.laddergame.view.InputView.*;
import static com.laddergame.view.OutputView.*;

public class LadderGameApplication {
    public static void main(String[] args) {
        String ParticipantNames = inputParticipantName();
        String gameResults = inputGameResult();
        int ladderHeight = inputLadderHeight();

        LadderGame ladderGame = LadderGame.valueOf(ladderHeight, ParticipantNames, gameResults);
        Lines lines = ladderGame.getLines();
        List<String> participantNames = ladderGame.getParticipantsNames();
        List<String> participantResults = parseInput(gameResults);
        LinesDto linesDto = LinesDto.from(lines);

        outputLadderGameResult(linesDto.getGameResult(), participantNames, participantResults);

        while(true) {
            String targetParticipantName = inputToShowParticipantResult();
            if(Objects.equals(targetParticipantName, APPLICATION_EXIT)) break;
            GameResults gameResults = ladderGame.getGameResults();
            boolean showsAllGameResults = Objects.equals(targetParticipantName, EVERY_PARTICIPANT);

            GameResultDto participantResultDto = showsAllGameResults ?
                    GameResultDto.from(gameResults) : GameResultDto.from(gameResults, targetParticipantName);

            if(showsAllGameResults) {
                outputAllParticipantResults(participantNames, participantResultDto.getParticipantResults());
                continue;
            }

            outputParticipantResult(participantResultDto.getParticipantResults().get(0));
        }
    }
}
