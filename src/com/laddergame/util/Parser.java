package com.laddergame.util;

import java.util.List;

public class Parser {
    public static List<String> parseInput(String inputString) {
        return List.of(inputString.split(PARSE_DELIMITER));
    }
    
    private static final String PARSE_DELIMITER = ",";
}
