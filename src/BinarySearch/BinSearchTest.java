package BinarySearch;

import org.junit.jupiter.api.Test;

public class BinSearchTest {
    @Test
    public void BinSearchTest01(){
        int[] testArr = {1,2,3,4,5,6,7,9,10,11};
        int ans = BinSearch.search(testArr, 4);
        System.out.println(ans);

    }
}
