package DP;

public class cb {
    public static void main(String[] args) {
        int ans = combination(5,5);
        System.out.println("ans:" + ans);
    }
    public static int combination(int from, int select){
        int ans = 1;
        int x = from;
        int y = select;
        int z = x - y;
        while(x >= 1){
            ans = ans * x;
            x --;
        }
        int div = 1;
        while(y >= 1){
            div = div * y;
            y --;
        }
        while(z > 1){
            div = div * z;
            z --;
        }
        return ans/div;
    }
}

