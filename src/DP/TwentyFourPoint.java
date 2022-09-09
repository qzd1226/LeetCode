package DP;

import org.junit.jupiter.api.Test;
import java.util.*;
public class TwentyFourPoint {
    boolean ans;
    @Test
    public void testTwentyFourPoint(){
        ans = false;
        int[] arr = {4,1,8,7};
        LinkedList<Double> list = new LinkedList<Double>();
        for(int i = 0; i < arr.length; i++){
            list.add((double)arr[i]);
        }
        dfs(list);
        System.out.println(ans);
    }
    public void dfs(LinkedList<Double> list){
        if(ans == true){
            return;
        }
        int len = list.size();
        //System.out.println(len);
        if(len == 1){
            if(Math.abs(list.get(0) - 24) < 0.0000001 ){
                ans = true;
            }
            return;
        }else{
            for(int i = 0; i < list.size(); i++){
                for(int j = 0; j < list.size(); j++){
                    if(i == j) continue;
                    LinkedList<Double> temp = new LinkedList<Double>(list);
                    double first = list.get(i);
                    double second = list.get(j);
                    list.remove((Double)first);
                    list.remove((Double)second);
                    for(int k = 0; k < 4; k++){
                        double newCard = 0;
                        if(k == 0){
                            newCard = first + second;
                        }else if(k == 1){
                            newCard = first - second;
                        }else if(k == 2){
                            newCard = first / second;
                        }else{
                            newCard = first * second;
                        }
                        LinkedList<Double> temp2 = new LinkedList<Double>(list);
                        list.addFirst((Double)newCard);
                        dfs(list);
                        list = temp2;
                    }
                    list = temp;
                }
            }
        }

    }
}

