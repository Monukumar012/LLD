package com.ttt.entity;

import java.util.Objects;

public final class Mark {
    private final Character symbol;
    public Mark(Character symbol){
        this.symbol = symbol;
    }

    public Character getSymbol() {
        return symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Mark mark)) return false;
        return Objects.equals(symbol, mark.symbol);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(symbol);
    }

    @Override
    public String toString() {
        return symbol.toString();
    }
}
