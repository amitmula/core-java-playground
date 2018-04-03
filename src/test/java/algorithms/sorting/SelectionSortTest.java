package algorithms.sorting;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by amit.k.mula on 20/3/17.
 */
public class SelectionSortTest {

    @Test
    public void testSlectionSort() throws Exception {
        int[] unsortedArray = {1,4,2,7,3,9,5,0};
        SelectionSort sorter = new SelectionSort();
        int[] sortedArray = sorter.slectionSort(unsortedArray);
        assertEquals(Arrays.toString(sortedArray), "[0, 1, 2, 3, 4, 5, 7, 9]");
    }
}