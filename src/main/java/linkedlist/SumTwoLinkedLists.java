/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    //https://leetcode.com/problems/add-two-numbers/description/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int nextLevel = 0;
        
        ListNode result = null;
        ListNode curr = null;
        
        ListNode currL1 = l1;
        ListNode currL2 = l2;
        
        while(true){
            if(currL1 == null && currL2 == null){
                break;
            }
            
            int sum = nextLevel;
            if(currL1 != null){
                sum += currL1.val;
            }
            
            if(currL2 != null){
                sum += currL2.val;
            }
            
            if(sum > 9){
                nextLevel=1;
            }else {
                nextLevel=0;
            }
            
            int finalSum = nextLevel == 1 ? sum - 10 : sum;
            ListNode finalNode = new ListNode(finalSum);
            if(curr == null){
                result = finalNode;
                curr=result;
            } else {
                curr.next = finalNode;
                curr = curr.next;
            }
            
            if(currL1 != null){
                currL1 = currL1.next;
            }
            
            if(currL2 != null){
                currL2 = currL2.next;
            }
        }
        
        if(nextLevel == 1){
            ListNode finalNode = new ListNode(1);
            if(curr == null){
                result = finalNode;
                curr = result;
            } else {
                curr.next = finalNode;
                curr = curr.next;
            }
        }
        
        return result;
    }
}
