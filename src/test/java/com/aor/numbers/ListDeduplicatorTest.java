package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ListDeduplicatorTest {

    @Test
    public void deduplicate() {

        ListDeduplicator deduplicator = new ListDeduplicator();
        List<Integer> deduplicate = deduplicator.deduplicate(Arrays.asList(1,2,4,2,5), new ListSorter());

        Assertions.assertEquals(Arrays.asList(1,2,4,5), deduplicate);
    }

    @Test
    public void deduplicate_bug_8726() {
/*
        class StubListSorter implements GenericListSorter{
            @Override
            public List<Integer> sort(List<Integer> list) {
                return Arrays.asList(1,2,4);
            }
        }
*/
        GenericListSorter sorter = Mockito.mock(GenericListSorter.class);
        Mockito.when(sorter.sort(Mockito.anyList())).thenReturn(Arrays.asList(1, 2, 2, 4));
        ListDeduplicator deduplicator = new ListDeduplicator();
        List<Integer> deduplicate = deduplicator.deduplicate(Arrays.asList(1,2,4,2), sorter);

        Assertions.assertEquals(Arrays.asList(1,2,4), deduplicate);
    }
}
