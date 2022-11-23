package BST;
import java.util.*;
public class Inorder_Iteration {
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> ans = new LinkedList();
            if(root == null){
                return ans;
            }
            Stack<TreeNode> stack = new Stack<TreeNode>();
            TreeNode node = root;
            while(node != null || !stack.isEmpty()){
                if(node != null){
                    stack.push(node);
                    node = node.left;
                }else{
                    node = stack.pop();
                    ans.add(node.val);
                    node = node.right;
                }
            }
            return ans;
        }
    }
}
