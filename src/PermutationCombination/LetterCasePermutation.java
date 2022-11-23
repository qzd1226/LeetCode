package PermutationCombination;
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

public class LetterCasePermutation {
    public static void main(String[] args) {
        String input = "a1b2";
        List<String> ans = letterCasePermutation(input);
        for(int i = 0; i < ans.size(); i++){
            System.out.println(ans.get(i));
        }
    }
    public  static List<String> letterCasePermutation(String s) {
        int len = s.length();
        Deque<String> que = new LinkedList<String>();
        que.addFirst(new String());
        for(int i = 0; i < s.length(); i++){
            if(!Character.isLetter(s.charAt(i))){
                int length = que.size();
                for(int j = 0; j < length; j++){
                    String cur = que.pollFirst();
                    cur = cur + s.charAt(i);
                    que.addLast(cur);
                }
            }else{
                int length = que.size();
                for(int j = 0; j < length; j++){
                    String cur = que.pollFirst();
                    String cur2 = new String(cur);
                    if(s.charAt(i) >= 'a' && s.charAt(i) <='z'){
                        cur = cur + s.charAt(i);
                        cur2 = cur2 + (char)(s.charAt(i) - 32);
                    }else{
                        cur = cur + s.charAt(i);
                        cur2 = cur2 + (char)(s.charAt(i) + 32);
                    }
                    que.addLast(cur);
                    que.addLast(cur2);
                }
            }
        }
        List<String> ans = (List)que;
        return ans;
    }
}
