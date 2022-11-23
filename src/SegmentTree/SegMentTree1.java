package SegmentTree;

import org.junit.jupiter.api.Test;

public class SegMentTree1 {
    @Test
    public void test01(){
        int[] arr = {1,3,5,7,9,11};
        int left = 0;
        int right = arr.length - 1;
        TreeNode root = buildSegTree(arr,0,right);
        System.out.println("before:" + root.val);

        // index is the index of the value you want to changes
        // changes is changes  for example 1 -> 2  changes = 1, 1 - > 0 changes = - 1
        upDate(0,-1,root,0,right);
        System.out.println("after:" + root.val);
    }
    public TreeNode buildSegTree(int[] nums, int left , int right){
        if(left == right){
            TreeNode newNode = new TreeNode(nums[left]);
            return newNode;
        }else{
            TreeNode newNode = new TreeNode();
            int mid = left + (right - left)/2;
            newNode.left = buildSegTree(nums,left,mid);
            newNode.right = buildSegTree(nums,mid+1,right);
            newNode.val = newNode.left.val + newNode.right.val;
            return newNode;
        }
    }
    public void upDate(int index, int changes, TreeNode root, int left, int right){
        if(left == right){
            root.val = root.val + changes;
            return;
        }else {
            root.val = root.val + changes;
            int mid = left + (right - left)/2;
            if(index <= mid){
                upDate(index,changes,root.left,left,mid);
            }else{
                upDate(index,changes,root.right,mid+1,right);
            }
        }
    }
}
