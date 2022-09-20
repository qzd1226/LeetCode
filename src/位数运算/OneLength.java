//面试题 05.03. 翻转数位
//        给定一个32位整数 num，你可以将一个数位从0变为1。请编写一个程序，找出你能够获得的最长的一串1的长度。
//
//        示例 1：
//
//        输入: num = 1775(110111011112)
//        输出: 8
//        示例 2：
//
//        输入: num = 7(01112)
//        输出: 4



package 位数运算;

public class OneLength {

    public static void main(String[] args) {
        int num = -5;
        System.out.println(reverseBits(num));
        // 关于 <<
        for(int i = 0; i < 32; i ++){
            System.out.println("对1移动位置:"+ (1 << i));
            System.out.println("不断加2：" + (i<<1));
        }
        // 关于 & 位运算
        int sum = 0;
        for(int i = 0; i < 5; i++){
            sum = sum + (1 << i);
        }
        for(int i = 0; i < 4; i++){
            int temp = 1 << i;
            System.out.println("num:" + temp);
            System.out.println("sum:" + sum);
            System.out.println("res of sum & num :" + ( sum & temp));
        }
        System.out.println("--------------------------");
        for(int i = 0; i < 4; i++){
            int temp = 1 << i;
            System.out.println("num:" + temp);
            System.out.println("sum:" + sum);
            System.out.println("res of sum | num :" + ( sum | temp));
        }
        System.out.println("--------------------------");
        for(int i = 0; i < 4; i++){
            int temp = 1 << i;
            System.out.println("num:" + temp);
            System.out.println("sum:" + sum);
            System.out.println("res of sum ^ num :" + ( sum ^ temp));
        }


    }

    public static int reverseBits(int num) {
        if(num == -1){
            return 32;
        }
        int ans = 1;
        int curCount = 0;
        int preCount = 0;
        for(int i = 0; i < 32; i++){
            if((num & (1<<i)) != 0){
                curCount++;
                ans = Math.max(ans,(preCount + curCount));
            }else{
                ans = Math.max(ans,(preCount + curCount + 1));
                preCount = curCount;
                curCount = 0;
            }
            ans = Math.max(ans,(preCount + curCount + 1));
        }
        return ans;
    }
}
