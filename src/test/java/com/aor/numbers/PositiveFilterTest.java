package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class PositiveFilterTest {
    @Test
    public void positivefilter() {
        GenericListFilter positivef = new PositiveFilter();
        boolean res = positivef.accept(-5);
        Assertions.assertEquals(false, res);
    }
    @Test
    public void positivefilter2() {
        GenericListFilter positivef = new PositiveFilter();
        boolean res = positivef.accept(5);
        Assertions.assertEquals(true, res);
    }
    @Test
    public void positivefilter0() {
        GenericListFilter positivef = new PositiveFilter();
        boolean res = positivef.accept(0);
        Assertions.assertEquals(true, res);
    }
}
