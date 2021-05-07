package linkedlist;

/**
 * 234. 回文链表
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class Problem243 {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        // ①找到前半部分链表的尾节点
        ListNode firstHalfEndNode = endOfFirstHalf(head);
        // ②反转后半部分链表
        ListNode secondHalfStartNode = reverseList(firstHalfEndNode.next);

        // ③判断是否是回文
        ListNode p1 = head;
        ListNode p2 = secondHalfStartNode;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // ④恢复链表
        firstHalfEndNode.next = reverseList(secondHalfStartNode);

        // ⑤返回结果
        return result;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null, current = head;
        while (current != null) {
            ListNode tmp = current.next;
            current.next = prev;
            prev = current;
            current = tmp;
        }
        return prev;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
