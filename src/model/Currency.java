package model;

public class Currency {

    private final char symbol;
    private final String code;
    private final String name;

    public Currency(char symbol, String code, String name) {
        this.symbol = symbol;
        this.code = code;
        this.name = name;
    }

    public char getSymbol() {
        return symbol;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}