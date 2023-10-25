package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ListFiltererTest {
    @Test
    public void listfilterer() {
        GenericListFilter filter = Mockito.mock(GenericListFilter.class);
        Mockito.when(filter.accept(Mockito.anyInt())).thenReturn(true);
        ListFilterer listf = new ListFilterer(filter);
        List<Integer> filtered = listf.filter(Arrays.asList(1,2,3,4));
        Assertions.assertEquals(Arrays.asList(1,2,3,4), filtered);
    }
    @Test
    public void listfilterer_f() {
        GenericListFilter filter = Mockito.mock(GenericListFilter.class);
        Mockito.when(filter.accept(Mockito.anyInt())).thenReturn(false);
        ListFilterer listf = new ListFilterer(filter);
        List<Integer> filtered = listf.filter(Arrays.asList(-1,-2,-3,-4));
        Assertions.assertEquals(Arrays.asList(), filtered);
    }
    @Test
    public void listfiltererf() {
        GenericListFilter filter = Mockito.mock(GenericListFilter.class);
        Mockito.when(filter.accept(1)).thenReturn(true);
        Mockito.when(filter.accept(-1)).thenReturn(false);
        Mockito.when(filter.accept(-2)).thenReturn(false);
        Mockito.when(filter.accept(2)).thenReturn(true);
        ListFilterer listf = new ListFilterer(filter);
        List<Integer> filtered = listf.filter(Arrays.asList(-1, -2, 1,2));
        Assertions.assertEquals(Arrays.asList(1,2), filtered);
    }
}
