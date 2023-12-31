package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ListAggregatorTest {
    private List<Integer> list;
    @BeforeEach
    void init(){
        list = Arrays.asList(1,2,4,2,5);
    }

    @Test
    public void sum() {

        ListAggregator aggregator = new ListAggregator();
        int sum = aggregator.sum(list);

        Assertions.assertEquals(14, sum);
    }

    @Test
    public void max() {

        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list);

        Assertions.assertEquals(5, max);

    }

    @Test
    public void max2() {
        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(Arrays.asList(5,-2,4,5,5));

        Assertions.assertEquals(5, max);

    }
    @Test
    public void max3() {
        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(Arrays.asList(1));
        Assertions.assertEquals(1, max);
    }

    @Test
    public void max4() {
        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(Arrays.asList(1));
        Assertions.assertEquals(1, max);
    }

    @Test
    public void max5() {
        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(Arrays.asList(0,0,0,0));
        Assertions.assertEquals(0, max);
    }
    @Test
    public void max_bug_7263() {
        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(Arrays.asList(-1,-4,-5));
        Assertions.assertEquals(-1, max);
    }

    @Test
    public void min() {

        ListAggregator aggregator = new ListAggregator();
        int min = aggregator.min(list);

        Assertions.assertEquals(1, min);
    }

    @Test
    public void distinct() {

        ListAggregator aggregator = new ListAggregator();
        int distinct = aggregator.distinct(list);

        Assertions.assertEquals(4, distinct);
    }

    @Test
    public void distinct_bug_8736() {
/*
        class StubListDeduplicator implements GenericListDeduplicator {

            @Override
            public List<Integer> deduplicate(List<Integer> list, GenericListSorter listSorter) {
                return Arrays.asList(1, 2, 4);
            }
        } */
        GenericListDeduplicator deduplicator = Mockito.mock(GenericListDeduplicator.class);
        Mockito.when(deduplicator.deduplicate(Mockito.anyList(), Mockito.any())).thenReturn(Arrays.asList(1, 2, 4));
        ListAggregator aggregator = new ListAggregator(deduplicator);
        int distinct = aggregator.distinct(Arrays.asList(1,2,4,2));

        Assertions.assertEquals(3, distinct);
    }
}
