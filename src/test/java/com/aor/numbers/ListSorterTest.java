package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ListSorterTest {

    @Test
    public void sort() {

        ListSorter sorter = new ListSorter();
        List<Integer> sorted = sorter.sort(Arrays.asList(3, 2, 6, 1, 4, 5, 7));

        Assertions.assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7), sorted);
    }

    @Test
    public void sort_bug_8726() {
        ListSorter sorter = new ListSorter();
        List<Integer> sorted = sorter.sort(Arrays.asList(1,2,4,2 ));

        Assertions.assertEquals(Arrays.asList(1,2,2,4), sorted);
    }
}

