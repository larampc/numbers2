package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DivisibleByFilterTest {
    @Test
    public void DivisibleByFilter() {
        GenericListFilter divisblef = new DivisibleByFilter(3);
        boolean res = divisblef.accept(15);
        Assertions.assertEquals(true, res);
    }
    @Test
    public void DivisibleByFilter2() {
        GenericListFilter divisblef = new DivisibleByFilter(3);
        boolean res = divisblef.accept(14);
        Assertions.assertEquals(false, res);
    }
    @Test
    public void DivisibleByFilter0() {
        GenericListFilter divisblef = new DivisibleByFilter(0);
        try {
            boolean res = divisblef.accept(14);
            Assertions.fail();
        }
        catch (ArithmeticException e) {}
        catch (Exception e) {
            Assertions.fail();
        }
    }
}
