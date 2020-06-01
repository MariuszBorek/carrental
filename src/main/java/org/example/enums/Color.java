package org.example.enums;

public enum Color {

    RED("#FF0000"),
    YELLOW("F7FF00"),
    ORANGE("FFD800"),
    BLUE("5D75FF"),
    PURPLE("C100FF"),
    GRAY("BFBFBF"),
    SILVER("#E2E2E2"),
    WHITE("FFFFFF"),
    BLACK("000000");

    private String hex;

    Color(String hex) {
        this.hex = hex;
    }

    public String getHex() {
        return hex;
    }

    // ordinal()    enum -> nr
    // valueOf()    String -> enum
    // values()     int -> enum


}
