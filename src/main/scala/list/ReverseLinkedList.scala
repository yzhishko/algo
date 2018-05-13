/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
object Solution {
    def reverseList(head: ListNode): ListNode = {
        
        def loop(list: ListNode, prev: ListNode): ListNode = {
            list match {
                case currHead: ListNode =>
                  val next: ListNode = currHead.next
                  currHead.next = prev
                  loop(next, currHead)
                case _ =>
                  prev;
            }
        }
        
        loop(head, null)
    }
}
