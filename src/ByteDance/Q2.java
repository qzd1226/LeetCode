package ByteDance;
// 工作量为N,效率从1开始累加，最大效率为M
//最大效率最多持续T分钟，持续T分钟会被强制休息10分钟，1开始以后每分钟可以主动休息五分钟，效率变为i休息前的一半（向下取证）
//最快可以多久完成工作。
public class Q2 {
    public static void main(String[] args) {
        System.out.println(minTime(26,5,3));
    }
    //1,2,3,3,3,3,3
    public static int minTime(int workload, int time, int eff){
        int ans = 0;
        int cur = 1;
        int t = 0;
        while(workload > 0){
            workload = workload - cur;
            System.out.println("cur_eff:" + cur);
            //System.out.println("remain:" + workload);
            ans ++;
            if(cur < eff) {
                cur = cur + 1;
            }
            if(workload < 0){
                return ans;
            }
            if(cur == eff){
                t = t + 1;
                if(t == time){
                    ans = ans + 5;
                    cur = cur/2;
                    t = 0;
                }
            }
        }
        return -1;
    }
}
