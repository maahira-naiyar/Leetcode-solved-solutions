/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int minDist = Integer.MAX_VALUE, maxDist = 0, dist = 0;

        ListNode node = head, prev = head;
        boolean critical = false;

        while (node.next != null)
        {
            if ((node.val > prev.val && node.val > node.next.val) || (node.val < prev.val && node.val < node.next.val))
            {
                // Not the first critical node
                if (critical)
                {
                    minDist = Math.min(minDist, dist);
                    maxDist += dist;
                }
                
                dist = 0;
                critical = true;
            }

            prev = node;
            node = node.next;
            dist++;
        }

        return new int[]{minDist == Integer.MAX_VALUE ? -1 : minDist, maxDist > 0 ? maxDist : -1};
    }
}