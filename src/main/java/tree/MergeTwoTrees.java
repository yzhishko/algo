/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.lang.*;

class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null){
            return t2;
        }
        if(t2 == null){
            return t1;
        }
        
        Queue<Pair> queue = new LinkedList<>();        
        TreeNode result = new TreeNode(t1.val + t2.val);
        queue.add(new Pair(t1, t2, result, 0));
        
        while(!queue.isEmpty()){
            Pair curr = queue.poll();
            
            if(curr.first == null && curr.second == null){
                continue;
            }
            
            if(curr.leftOrRight == 0){
              queue.add(new Pair(curr.firstLeft(), curr.secondLeft(), curr.parent, 1));
              queue.add(new Pair(curr.firstRight(), curr.secondRight(), curr.parent, 2));
                continue;
            }
            
            TreeNode currResult = new TreeNode(curr.firstVal() + curr.secondVal());
            
            if(curr.leftOrRight == 1){
              curr.parent.left = currResult;
            } else {
                curr.parent.right = currResult;
            }
        
            queue.add(new Pair(curr.firstLeft(), curr.secondLeft(), currResult, 1));
            queue.add(new Pair(curr.firstRight(), curr.secondRight(), currResult, 2));
            
        }
                  
        return result;
    }
}
                  
class Pair {
    TreeNode first;
    TreeNode second;
    TreeNode parent;
    int leftOrRight = 0;
    
    Pair(TreeNode first, TreeNode second, TreeNode parent, int leftOrRight){
        this.first = first;
        this.second = second;
        this.parent = parent;
        this.leftOrRight = leftOrRight;
    }
    
    int firstVal(){
        return first == null? 0 : first.val;
    }
    
    int secondVal(){
        return second == null? 0 : second.val;
    }
                      
    TreeNode firstLeft() {
        return first == null? null : first.left;
    }
                      
    TreeNode firstRight() {
        return first == null? null : first.right;
    }
    
    TreeNode secondLeft() {
        return second == null? null : second.left;
    }
    
    TreeNode secondRight() {
        return second == null? null : second.right;
    }
    
    String toStr() {
        return "First: " + firstVal() + ", second: " + secondVal() + ", lor: " + leftOrRight;
    }
}
