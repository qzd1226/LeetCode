package BST;
import java.util.*;

public class zhongxu {
    class Solution {
        public int minDiffInBST(TreeNode root) {
            Stack<TreeNode> stack = new Stack<TreeNode>();
            //先将所有的left 入栈
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            while(!stack.isEmpty()){
                TreeNode node = stack.peek();
                System.out.println(node.val);
                if(node.right == null){
                    node = stack.pop();
                    while(!stack.isEmpty() && stack.peek().right == node){
                        node = stack.pop();
                    }
                }else{
                    node = node.right;
                    while(node != null){
                        stack.push(node);
                        node = node.left;
                    }
                }
            }
            return 0;
        }
    }
}
