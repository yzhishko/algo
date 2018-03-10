class LinkedListCycle {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next = head;

        System.out.println(hasCycle(head));
    }

    static boolean hasCycle(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null) {
            if (slow == fast) {
                return true;
            }

            if (slow == null || fast.next == null || fast.next.next == null) {
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }
}
