package com.aor.numbers;

public class DivisibleByFilter implements GenericListFilter{
    private Integer number1;
    DivisibleByFilter(Integer number1) {
        this.number1 = number1;
    }
    @Override
    public boolean accept(Integer number) {
        return number % number1 == 0;
    }
}
