package StringProblems;

import org.junit.jupiter.api.Test;


//IPV4地址可以用一个32位无符号整数来表示，一般用点分方式来显示，点将IP地址分成4个部分，每个部分为8位，表示成一个无符号整数（因此正号不需要出现），如10.137.17.1，是我们非常熟悉的IP地址，一个IP地址串中没有空格出现（因为要表示成一个32数字）。
//
//        现在需要你用程序来判断IP是否合法。
//
//        数据范围：数据组数：1\le t\le 18\1≤t≤18
//        进阶：时间复杂度：O(n)\O(n) ，空间复杂度：O(n)\O(n)
//输入描述：
//        输入一个ip地址，保证不包含空格
//
//        输出描述：
//        返回判断的结果YES or NO
//
//        示例1
//        输入：
//        255.255.255.1000
//        输出：
//        NO


public class Legal_IP {
    @Test
    public void Legal_IP_Test(){
        System.out.println("hello");
        String test = "192.168.1.1";
        boolean res = isLegal(test);
        System.out.println(res);
    }
    public static boolean isLegal(String str){
        String[] stringArr = str.split("\\.");
        if(stringArr.length != 4){
            return false;
        }
        for(int i = 0; i < stringArr.length; i++){
            //System.out.println(stringArr[i]);
            if(stringArr[i].length() == 0){
                return false;   // ..125.127
            }
            if(!Character.isDigit(stringArr[i].charAt(0))){
                return false;   //..
            }
            int len = stringArr[i].length();
            //System.out.println(stringArr[i]);
            if(len > 1 && stringArr[i].charAt(0) == '0'){
                return false;   // 09.125.123.45
            }
            int temp = Integer.parseInt(stringArr[i]);
            if(temp > 255){
                return false;
            }
        }
        return true;
    }
}
