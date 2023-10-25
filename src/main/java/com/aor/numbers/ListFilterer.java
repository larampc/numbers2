package com.aor.numbers;

import java.util.ArrayList;
import java.util.List;

public class ListFilterer {
    private final GenericListFilter filter;
    public ListFilterer(GenericListFilter filter) {
        this.filter = filter;
    }
    public List<Integer> filter(List<Integer> list) {
        List<Integer> result = new ArrayList<>();
        for (Integer c: list) {
            if (this.filter.accept(c)) {
                result.add(c);
            }
        }
        return result;
    }
}
