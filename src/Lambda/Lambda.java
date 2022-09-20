package Lambda;

import java.util.Arrays;
import java.util.Comparator;

public class Lambda {
    public static void main(String[] args) {
        Cal cal = (int a, int b) -> {return a + b;};
        System.out.println(cal.add(1,2));
        int[] first = {1,9,30,4};
        int[] second= {10,9,8,7};
        int[] h = new int[first.length];
        int[][] matrix = new int[first.length][2];
        for(int i = 0; i < first.length;i++){
            matrix[i][0] = first[i];
            matrix[i][1] = i;
        }
        Arrays.sort(matrix, (a,b) ->(a[0] - b[0]));
        for (int i = 0; i < matrix.length; i++) {
            System.out.println("num: " + matrix[i][0] + "index:" + matrix[i][1]);
        }
    }
    interface Cal{
        int add(int a, int b);
    }

}
