package BST;
import java.util.*;

public class Postorder_Iteration {
    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<Integer>();
            if(root == null){
                return ans;
            }
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.push(root);
            while(!stack.isEmpty()){
                TreeNode cur = stack.pop();
                ans.add(cur.val);
                //先遍历左边
                if(cur.left != null){
                    stack.push(cur.left);
                }
                //再遍历右边
                if(cur.right != null){
                    stack.push(cur.right);
                }
                // 中右左 ———> 翻转 左右中
            }
            //反转list
            Collections.reverse(ans);
            return ans;
        }
    }
}
