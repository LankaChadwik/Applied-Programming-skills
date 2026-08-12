class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroupEnd = dummy;

        while (true) {
            ListNode kthNode = getKthNode(prevGroupEnd, k);
            if (kthNode == null) {
                break;
            }

            ListNode nextGroupStart = kthNode.next;
            
            ListNode prev = nextGroupStart;
            ListNode curr = prevGroupEnd.next;

            while (curr != nextGroupStart) {
                ListNode nextTemp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextTemp;
            }

            ListNode firstNodeOfGroup = prevGroupEnd.next;
            prevGroupEnd.next = kthNode;
            
            prevGroupEnd = firstNodeOfGroup;
        }

        return dummy.next;
    }

    private ListNode getKthNode(ListNode start, int k) {
        while (start != null && k > 0) {
            start = start.next;
            k--;
        }
        return start;
    }
}