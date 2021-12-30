package com.laddergame.view;

enum ViewDelimiter {
    LADDER("-----"),
    NO_LADDER("     "),
    VERTICAL_LINE("|"),
    LADDER_PADDING("    ")
    ;

    ViewDelimiter(String delimiter) {
        this.value = delimiter;
    }

    public final String value;
}