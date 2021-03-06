package com.laddergame.dto;

import com.laddergame.domain.Line;
import com.laddergame.domain.Lines;

import java.util.List;
import java.util.stream.Collectors;

public class LinesDto {
    private static List<List<Boolean>> gameResult;

    LinesDto(List<List<Boolean>> lines) {
        gameResult = lines;
    }

    public List<List<Boolean>> getGameResult() {
        return gameResult;
    }

    public static LinesDto from(Lines result) {
        List<List<Boolean>> lines = result
                .getLines()
                .stream()
                .map(Line::getHasLadders)
                .collect(Collectors.toList());

        return new LinesDto(lines);
    }
}
