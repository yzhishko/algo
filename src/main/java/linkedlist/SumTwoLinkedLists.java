/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    ////https://leetcode.com/problems/add-two-numbers/description/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int nextLevel = 0;
        
        ListNode currL1 = l1;
        ListNode prevL1 = l1;
        
        ListNode currL2 = l2;
        ListNode prevL2 = l2;
        
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
            
            if(currL1 != null){
                currL1.val = finalSum;
                prevL1 = currL1;
                currL1 = currL1.next;
            } else {
                prevL1.next = new ListNode(finalSum);
                prevL1 = prevL1.next;
            }
            
            if(currL2 != null){
                currL2.val = finalSum;
                prevL2 = currL2;
                currL2 = currL2.next;
            } else {
                prevL2.next = new ListNode(finalSum);
                prevL2 = prevL2.next;
            }
        }
        
        if(nextLevel == 1){
            ListNode finalNode = new ListNode(1);
            if(currL1 == null){
                prevL1.next = finalNode;
            } else {
                currL1.next = finalNode;
            }
            
            if(currL2 == null){
                prevL2.next = finalNode;
            } else {
                currL2.next = finalNode;
            }
            
        }
        
        return l1;
    }
}
