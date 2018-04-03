package algorithms.sorting;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class QuickSortTest {

    @Test
    public void testSort() throws Exception {
        int[] arr = {1,5,3,6,2,7,1};
        QuickSort sorter = new QuickSort();
        sorter.sort(arr, 0, arr.length-1);
        assertEquals(Arrays.toString(arr), "[1, 1, 2, 3, 5, 6, 7]");
    }
}