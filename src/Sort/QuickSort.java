package Sort;

import org.junit.jupiter.api.Test;

public class QuickSort {
    @Test
    public void QuickSortTest(){
        int[] test = {2,3,1,3,2,4,6,7,9,2,19};
        QuickSort(test,0,test.length-1);
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
        }
    }
    public void QuickSort(int[] arr, int left, int right){
        if(left <= right){
            int i = left;
            int j = right;
            int base = arr[left];
            while(i < j){
                while(i < j && arr[j] >= base){
                    j--;
                }
                while( i < j && arr[i] <= base){
                    i++;
                }
                if(i < j ){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = arr[i];
                }
            }
            arr[left] = arr[i];
            arr[i] = base;
            QuickSort(arr,left,i - 1);
            QuickSort(arr, i + 1, right);
        }
    }
}
