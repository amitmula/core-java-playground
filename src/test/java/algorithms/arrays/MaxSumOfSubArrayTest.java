package algorithms.arrays;

import org.junit.Test;
import org.junit.Assert;

public class MaxSumOfSubArrayTest {

    @Test
    public void testMaxSum() throws Exception {
        MaxSumOfSubArray driver = new MaxSumOfSubArray();
        int[] arr = {100, 200, 300, 400};
        Assert.assertEquals(driver.maxSum(arr, 2), 700);
    }
}