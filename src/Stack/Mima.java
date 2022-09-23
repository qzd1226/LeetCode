package Stack;
//3[a2[c]]
//accaccacc

import java.util.*;
public class Mima {
    public static void main(String[] args) {
        String str = "3[a2[c]2[e]4[mb]]";
        String ans = getCode(str);
        System.out.println("ans:" + ans);
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
            }else if(str.charAt(i) == '['){
                strings.add("[");
            } else if(str.charAt(i) == ']'){
                String curAns = new String();
                while(!strings.peek().equals("[")){
                    String curStr = strings.pollFirst();
                    int curNum = nums.pollFirst();
                    for(int j = 0; j < curNum; j++){
                        curAns = curAns + curStr;
                    }
                    if(strings.peek().equals("[")){
                        break;
                    }
                    if(!strings.isEmpty()){
                        curAns = strings.pollFirst() + curAns;
                    }
                }
                strings.pollFirst();
                if(nums.isEmpty() && strings.isEmpty()){
                    return curAns;
                }
                strings.addFirst(curAns);
            }
        }
        return ans;
    }
}
