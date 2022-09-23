package Stack;
//3[a2[c]]
//accaccacc

import java.util.*;
public class Mima {
    public static void main(String[] args) {
        String str = "7[ezb3[a2[cp]]]";
        String ans = getCode(str);
        System.out.println(ans);
    }
    public static String getCode(String str){
        String ans = new String();
        Deque<String> strings = new LinkedList<String>();
        Deque<Integer> nums = new LinkedList<Integer>();
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                String curString = new String();
                while(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                    curString = curString + str.charAt(i);
                    i++;
                }
                i--;
                nums.addFirst(Integer.parseInt(curString));
            }else if((str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')|| (str.charAt(i) >= 'a' && str.charAt(i) <= 'z')){
                String curString = new String();
                while((str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')|| (str.charAt(i) >= 'a' && str.charAt(i) <= 'z')){
                    curString = curString + str.charAt(i);
                    i++;
                }
                i--;
                strings.addFirst(curString);
            }else if(str.charAt(i) == ']'){
                int num = nums.pollFirst();
                String t = strings.pollFirst();
                String cur = new String();
                for(int j = 0; j < num; j++){
                    cur = cur + t;
                }
                if(!strings.isEmpty()){
                    cur = strings.pollFirst() + cur;
                }
                if(strings.isEmpty() && nums.isEmpty()){
                    return cur;
                }else{
                    strings.addFirst(cur);
                }
            }
        }
        return ans;
    }
}
