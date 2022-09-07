package javaString;

import org.junit.jupiter.api.Test;
import java.util.*;
//描述
//        输入一个字符串，返回其最长的数字子串，以及其长度。若有多个最长的数字子串，则将它们全部输出（按原字符串的相对位置）
//        本题含有多组样例输入。
//
//        数据范围：字符串长度 1 \le n \le 200 \1≤n≤200  ， 保证每组输入都至少含有一个数字
//        输入描述：
//        输入一个字符串。1<=len(字符串)<=200
//
//        输出描述：
//        输出字符串中最长的数字字符串和它的长度，中间用逗号间隔。如果有相同长度的串，则要一块儿输出（中间不要输出空格）。
//
//        示例1
//        输入：
//        abcd12345ed125ss123058789
//        a8a72a6a5yy98y65ee1r2
//        复制
//        输出：
//        123058789,9
//        729865,2
//        复制
//        说明：
//        样例一最长的数字子串为123058789，长度为9
//        样例二最长的数字子串有72,98,65，长度都为2
public class LongestSubDigString {
    @Test
    public void LSDSTest(){
        String test = "a8a72a6a5yy98y65ee1r2";
        String ans = LSDS(test);
        System.out.println(ans);

    }
    public String LSDS(String str){
        Map<Integer, List<String>> table = new HashMap<Integer,List<String>>();
        int maxLen = 0;
        int curLen = 0;
        String curString = new String();
        boolean pre = false; // is previous char digit?
        for(int i = 0; i < str.length(); i++){
            char curChar = str.charAt(i);
            if(Character.isDigit(curChar)){
                if(pre == false){
                    curString = new String();
                    curString = curString + curChar;
                    curLen = 1;
                    pre = true;
                    if(curLen >= maxLen) {
                        maxLen = curLen;
                        List<String> tempList = table.getOrDefault(curLen, new LinkedList<String>());
                        tempList.add(curString);
                        table.put(curLen, tempList);
                    }
                }else {
                    curString = curString + curChar;
                    curLen = curLen + 1;
                    if (curLen >= maxLen) {
                        maxLen = curLen;
                        List<String> tempList = table.getOrDefault(curLen, new LinkedList<String>());
                        tempList.add(curString);
                        table.put(curLen, tempList);
                    }
                }
            }else{
                curLen = 0;
                pre = false;
            }
        }
        List<String> ansList = table.get(maxLen);
        String ans = new String();
        for(int i = 0; i < ansList.size(); i++){
            ans = ans + ansList.get(i);
        }
        ans = ans + "," + maxLen;
        return ans;
    }
}
