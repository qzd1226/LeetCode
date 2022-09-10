package DP;

import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.LinkedList;

public class SameSubString {
    @Test
    public void test1(){
        String a = "nvlrzqcjltmrejybjeshffenvkeqtbsnlocoyaokdpuxutrsmcmoearsgttgyyucgzgcnurfbubgvbwpyslaeykqhaaveqxijc";
        String b = "wkigrnngxehuiwxrextitnmjykimyhcbxildpnmrfgcnevjyvwzwuzrwvlomnlogbptornsybimbtnyhlmfecscmojrxekqmj";
        String ans = FindSameSubString(a,b);
        System.out.println(ans);

    }

    public static String FindSameSubString(String a, String b){
        int max_len = 0;
        String ans = new String();
        int a_len = a.length();
        List<Integer[]> lastSub = new LinkedList<Integer[]>();
        for(int i = 0; i < a.length();i++){
            char cur = a.charAt(i);
            Set<Integer> removeSet = new HashSet<Integer>();
            // get old the old substring
            for(int p = 0; p < lastSub.size(); p++){
                Integer[] oldSub = lastSub.get(p);
                if(((int)oldSub[0] + (int)oldSub[1] <  b.length())){
                    if(b.charAt(oldSub[0] + oldSub[1]) == cur){
                        oldSub[1] = oldSub[1] + 1;
                        if(oldSub[1] > max_len){
                            max_len = oldSub[1];
                            ans = b.substring(oldSub[0],oldSub[1] + oldSub[0]);
                        }
                    }else{
                        lastSub.remove(p);
                        p--;
                    }
                }
            }
            // put all the new head in to the temp list
            List<Integer[]> tempList = new LinkedList<Integer[]>();
            for(int j = 0; j < b.length(); j++){
                if(cur == b.charAt(j)){
                    Integer[] curArr = {j,1};
                    tempList.add(curArr);
                }
            }
            for(int z = 0; z < tempList.size(); z++){
                Integer[] tempA = tempList.get(z);
                lastSub.add(tempA);
            }
        }
        return ans;
    }
}
