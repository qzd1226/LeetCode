package DFS;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
public class FaMa {
    Set<Integer> set;
    int ans;
    int dfsNum;
    @Test
    public void FaMaTest(){
        ans = 1; // 0直接加进去
        set = new HashSet<Integer>();
        dfsNum = 0;
        int[] weight = {74,1,15,189};
        int[] nums = {6,4,2,6};
        set.add(0);
        for(int i = 0; i < weight.length; i++){
            List<Integer> list = new LinkedList<Integer>(set);
            for(int j = 0; j < nums[i]; j++ ){
                    for(int k = 0; k < list.size(); k++){
                        list.add((int)list.get(k) + weight[i] * j);
                    }
            }
        }
        System.out.println(set.size());
    }


}
