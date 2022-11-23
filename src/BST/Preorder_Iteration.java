package BST;
import java.util.*;

public class Preorder_Iteration {
    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> ans = new LinkedList<Integer>();
            if(root == null){
                return ans;
            }
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.push(root);
            while(!stack.isEmpty()){
                TreeNode cur = stack.pop();
                ans.add(cur.val);
                if(cur.right != null){
                    stack.push(cur.right);
                }
                if(cur.left != null){
                    stack.push(cur.left);
                }
            }
            return ans;
        }
    }
}
