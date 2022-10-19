package model;

public class Currency {

    private final String symbol;
    private final String code;
    private final String name;

    public Currency(String code, String name, String symbol) {
        this.symbol = symbol;
        this.code = code;
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}