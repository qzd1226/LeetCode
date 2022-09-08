package StringProblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class ArgumentParsing{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        // 标记是否遇到引号
        boolean hasQuotation = false;
        // 遍历字符串的左右指针
        int l = 0, r = 0;
        // 存放分解后的参数字符串
        List<String> ans = new ArrayList<>();
        while (r < s.length()) {
            char ch = s.charAt(r);
            if (ch == ' ') {
                if (!hasQuotation) {
                    ans.add(s.substring(l, r));
                    // 更新左右指针
                    l = r = r + 1;
                } else {
                    r++;
                }
            } else if (ch == '"') {
                if (hasQuotation) {
                    // 前面已有双引号，现在找到一对了，输出
                    ans.add(s.substring(l + 1, r)); // l + 1解释：跳过左双引号
                    // 更新左右指针
                    l = r = r + 2; // r + 2解释：跳过空格
                } else {
                    r++;
                }
                hasQuotation = !hasQuotation;
            } else {
                r++;
            }
        }
        // 处理最后一个参数（结尾字符非双引号才需处理，会被前面的while循环跳过）
        // 因为如果字符串的最后一个字符是双引号，则已经在前面的while循环处理了
        if (s.charAt(s.length() - 1) != '"') {
            ans.add(s.substring(l, r));
        }
        System.out.println(ans.size());
        for (String param : ans) {
            System.out.println(param);
        }
    }
}