package DP;

import org.junit.jupiter.api.Test;
import java.util.*;
public class TwentyFourPoint {
    boolean ans;
    @Test
    public void testTwentyFourPoint(){
        ans = false;
        int[] arr = {6,2,1,5};
        List<Double> list = new ArrayList<Double>();
        for(int i = 0; i < arr.length; i++){
            list.add((double)arr[i]);
        }
        dfs(list);
        System.out.println(ans);
    }
    public void dfs(List<Double> list){
        int len = list.size();
        if(len == 1){
            if(Math.abs(list.get(0) - 24) < 0.0000001 ){
                ans = true;
            }
            return;
        }else{
            for(int i = 0; i < list.size(); i++){
                for(int j = 0; j < list.size(); j++){
                    if(i == j) continue;
                    List<Double> temp = new ArrayList<Double>(list);
                    double first = list.get(i);
                    double second = list.get(j);
                    list.remove((Double)first);
                    list.remove((Double)second);
                    double newCard = first + second;
                    list.add(newCard);
                    List<Double> temp2 = new ArrayList<Double>(list);
                    dfs(list);
                    //回溯
                    list = temp2;
                    if(list.size() == 1){
                        list = new ArrayList<Double>();
                    }else{
                        list.remove((Double)newCard);
                    }
                    newCard = second - first;
                    list.add(newCard);
                    temp2 = new ArrayList<Double>(list);
                    dfs(list);
                    //回溯
                    list = temp2;
                    if(list.size() == 1){
                        list = new ArrayList<Double>();
                    }else{
                        list.remove((Double)newCard);
                    }
                    newCard = first * second;
                    list.add(newCard);
                    temp2 = new ArrayList<Double>(list);
                    dfs(list);
                    //回溯
                    list = temp2;
                    if(list.size() == 1){
                        list = new ArrayList<Double>();
                    }else{
                        list.remove((Double)newCard);
                    }
                    newCard = first / second;
                    list.add(newCard);
                    temp2 = new ArrayList<Double>(list);
                    dfs(list);
                    list = temp2;
                    if(list.size() == 1){
                        list = new ArrayList<Double>();
                    }else{
                        list.remove((Double)newCard);
                    }
                    //回溯
                    list = temp;
                }
            }
        }
    }
}

