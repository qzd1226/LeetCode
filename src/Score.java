import java.util.LinkedList;
import java.util.List;

public class Score{
    static List<List> ans;
    public static void main(String[] args) {
        int[] score = {2,4,8};
        int[] wrongRemain = {3,3,3};
        int target = 4;
        ans = new LinkedList<List>();
        LinkedList<Integer> list = new LinkedList<Integer>();
        dfs(score,wrongRemain,target,list,0);
        System.out.println(ans.size());

    }

    public static void dfs(int[] score, int[] wrongRemain, int remain, LinkedList<Integer> curAns, int num){
        if(num > 3){
            return;
        }
        num++;
        for(int i = 0; i < score.length; i++){
            if(wrongRemain[i] > 0){
                int curRemain = remain - score[i];
                System.out.println("减" + score[i]);
                wrongRemain[i]--;
                if(curRemain >= 0){
                    curAns.addFirst(score[i]);
                    if(curRemain== 0){
                        ans.add(curAns);
                        wrongRemain[i] ++;
                        curAns.pollLast();
                        return;
                    }else{
                        dfs(score,wrongRemain,curRemain,curAns,num);
                    }
                }
            }
        }
    }

}