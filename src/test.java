public class test {
    public static void main(String[] args) {
        int ans = getKthMagicNumber(6);
        System.out.println(ans);
    }
    public static int getKthMagicNumber(int k) {
        int[] dp = new int[k];
        int[] count = new int[3];
        dp[0] = 1;
        for(int i = 1; i < k; i ++ ){
            int one = dp[count[0]] * 3;
            int two = dp[count[1]] * 5;
            int three = dp[count[2]] * 7;
            if(one == two && one < three){
                count[0]++;
                count[1]++;
                dp[i] = one;
            }else if(two == three && two < one){
                count[1]++;
                count[2]++;
                dp[i] =two;
            }else if(one == three && one < two){
                count[0]++;
                count[2]++;
                dp[i] = one;
            }else if(one < two && one < three){
                count[0]++;
                dp[i] = one;
            }else if(two < one && two < three){
                count[1]++;
                dp[i] = two;
            }else{
                count[2]++;
                dp[i] = three;
            }
        }
        return dp[k-1];

    }
}
