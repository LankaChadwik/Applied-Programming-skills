class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;

            if (tail.next != null) {
                queue.add(tail.next);
            }
        }

        return dummy.next;
    }
}