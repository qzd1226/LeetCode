import org.junit.jupiter.api.Test;
import java.util.*;
public class ArraySortTest {
    @Test
    public void test(){
        int len = 10;
        int[] a = {1,2,3,4};
        int[] b = {100,101,30,71};
        Integer[] arr = new Integer[len];
        Arrays.sort(arr,(m, n) -> {
            return a[m] * b[n];
        });

    }
}
