package Greedy;

public class quicksort {
    public  static void quicksort(minCostToHireWorkers.WorkerEfficiency[] arr,int left, int right){
        if(right >= left){
            //保存基数
            minCostToHireWorkers.WorkerEfficiency basic = arr[left];
            //
            int i = left;
            int j = right;
            while (i < j){    //左指针小于右指针
                while (i < j && arr[j].efficient > basic.efficient) {
                    j--;
                }
                if( i < j ){
                    arr[i] = arr[j];        //将右指针对应小于基数的树枝放在左指针的位置
                    i++;                    //左指针向右移
                }
                while (i < j && arr[i].efficient < basic.efficient){    //相反， 找到大于基数的下标
                    i++;
                }
                if(i < j){
                    arr[j] = arr[i];        //大于基数的值赋给右指针所指的位置
                    j--;                    //右指针自减
                }
            }
            arr[i] = basic;                 //将基数放入到指针重合处
            quicksort(arr,left,i-1);
            quicksort(arr,i + 1, right);
        }
    }
}
