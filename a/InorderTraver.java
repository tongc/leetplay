package a;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class InorderTraver {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList();
        return t2(root, result);
        //return t(root, new ArrayList());
    }

    public List<Integer> t2(TreeNode current, List<Integer> result) {
        Stack<TreeNode> unvisited = new Stack<>();
        unvisited.push(current);
        while(unvisited.size()!=0) {
            current = unvisited.pop();
            while(current!=null) {
                result.add(current.val);
                TreeNode currentBackup = current;
                if(currentBackup.right!=null) {
                    unvisited.add(currentBackup.right);
                }
                current = current.left;
            }
        }
        return result;
    }


    public List<Integer> t(TreeNode root, List<Integer> result) {
        if(root!=null) {
            result.add(root.val);
            t(root.left,result);
            t(root.right,result);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode tn = new TreeNode(1);
        TreeNode tn1 = new TreeNode(2);
        TreeNode tn2 = new TreeNode(4);
        TreeNode tn3 = new TreeNode(5);
        TreeNode tn4 = new TreeNode(6);
        TreeNode tn5 = new TreeNode(7);
        TreeNode tn6 = new TreeNode(8);
        TreeNode tn7 = new TreeNode(9);

        tn.left = tn1;
        tn1.left = tn2;
        tn2.left = tn3;
        tn2.right = tn4;
        tn.right = tn5;
        tn5.left = tn6;
        tn5.right = tn7;
        List<Integer> result = new InorderTraver().preorderTraversal(tn);
        System.out.println(result);
    }
}
