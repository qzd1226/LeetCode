package 位数运算;
import java.util.*;
// LeetCode 784
//Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.
//
//        Return a list of all possible strings we could create. Return the output in any order.
//        Example 1:
//
//        Input: s = "a1b2"
//        Output: ["a1b2","a1B2","A1b2","A1B2"]
//        Example 2:
//
//        Input: s = "3z4"
//        Output: ["3z4","3Z4"]

//假设字符串 ss 有 mm 个字母，那么全排列就有 2^m
//        个字符串序列，且可以用位掩码 bits 唯一地表示一个字符串。
//
//        bits 的第 i 为 0 表示字符串 s 中从左往右第 i 个字母为小写形式；
//        bits 的第 i 为 1 表示字符串 s 中从左往右第 i 个字母为大写形式；
//        我们采用的位掩码只计算字符串 s 中的字母，对于数字则直接跳过，
//        通过位图计算从而构造正确的全排列。我们依次检测字符串第 i 个字符串 c：
//
//        如果字符串 cc 为数字，则我们直接在当前的序列中添加字符串 cc；
//        如果字符串 cc 为字母，且 cc 为字符串中的第 kk 个字母，如果掩码
//        bitsbits 中的第 kk 位为 00，则添加字符串 cc 的小写形式；
//        如果掩码 bitsbits 中的第 kk 位为 11，则添加字符串 cc 的大写形式；

public class LetterCasePermutation2 {
    public static void main(String[] args) {
        String input = "a1b2";
        List<String> ans = letterCasePermutation(input);
        for(int i = 0; i < ans.size(); i++){
            System.out.println(ans.get(i));
        }
        int m = 4; // 100
        for(int i = 0; i < 10; i++){
            System.out.println(m);
            m = 1<<m;
        }
    }
    public static List<String> letterCasePermutation(String s) {
        int n = s.length();
        int m = 0;
        for (int i = 0; i < n; i++) {
            if (Character.isLetter(s.charAt(i))) {
                m++;
            }
        }
        List<String> ans = new ArrayList<String>();
        for (int mask = 0; mask < (1 << m); mask++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0, k = 0; j < n; j++) {
                if (Character.isLetter(s.charAt(j)) && (mask & (1 << k++)) != 0) {
                    sb.append(Character.toUpperCase(s.charAt(j)));
                } else {
                    sb.append(Character.toLowerCase(s.charAt(j)));
                }
            }
            ans.add(sb.toString());
        }
        return ans;
    }
}
