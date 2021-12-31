package com.laddergame.dto;

import com.laddergame.domain.GameResult;
import com.laddergame.domain.GameResults;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static com.laddergame.util.ExceptionMessages.NO_SUCH_PARTICIPANT_EXCEPTION;

public class GameResultDto {
    private static List<String> participantResults;

    GameResultDto(String result) {
        participantResults = new ArrayList<>();
        participantResults.add(result);
    }

    GameResultDto(List<String> results) {
        participantResults = results;
    }

    public List<String> getParticipantResults() {
        return participantResults;
    }

    public static GameResultDto from(GameResults gameResults, String targetParticipant) throws NoSuchElementException {
        GameResult targetGameResult = gameResults.findByParticipantName(targetParticipant);

        if (targetGameResult == null) {
            throw new NoSuchElementException(NO_SUCH_PARTICIPANT_EXCEPTION);
        }
        return new GameResultDto(targetGameResult.getResult());
    }

    public static GameResultDto from(GameResults gameResults) {
        return new GameResultDto(gameResults.findAll()
                .stream()
                .map(GameResult::getResult)
                .collect(Collectors.toList())
        );
    }
}
