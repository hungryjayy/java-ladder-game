package com.laddergame.dto;

import com.laddergame.domain.GameResult;

import java.util.Map;

public class GameResultDto {
    private static String participantResult;

    GameResultDto(String result) {
        participantResult = result;
    }

    public String getParticipantResult() {
        return participantResult;
    }

    public static GameResultDto from(GameResult gameResult, String targetParticipant) {
        Map<String, String> matchedGameResult = gameResult.getMatchedGameResults();
        String result = matchedGameResult.get(targetParticipant);
        return new GameResultDto(result);
    }
}
