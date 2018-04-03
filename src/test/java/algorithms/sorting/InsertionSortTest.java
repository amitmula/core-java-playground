package algorithms.sorting;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class InsertionSortTest {

    @Test
    public void testInsertionSort() throws Exception {
        InsertionSort sorter = new InsertionSort();
        int[] arr = {4,3,5,2,6,1};
        sorter.insertionSort(arr);
        assertEquals(Arrays.toString(arr), "[1, 2, 3, 4, 5, 6]");
    }
}