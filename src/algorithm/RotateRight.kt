package algorithm

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。

示例 1:

输入: 1->2->3->4->5->NULL, k = 2
输出: 4->5->1->2->3->NULL
解释:
向右旋转 1 步: 5->1->2->3->4->NULL
向右旋转 2 步: 4->5->1->2->3->NULL
示例 2:

输入: 0->1->2->NULL, k = 4
输出: 2->0->1->NULL
解释:
向右旋转 1 步: 2->0->1->NULL
向右旋转 2 步: 1->2->0->NULL
向右旋转 3 步: 0->1->2->NULL
向右旋转 4 步: 2->0->1->NULL

 * Created by linnanwei on 2019/9/11
 * @author linnanwei
 */

class RotateRight {
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        if (k == 0){
            return head
        }
        head?.let{
            var len:Int = listNodeLength(head)
            var n = k % len
            if (n <= 0 || len == 1){
                return head
            }
            var tail: ListNode = head
            var cur: ListNode = head
            for (i in 1..len-n){
                tail = cur
                cur = cur.next!!
            }
            var newHead = cur
            var nextTail = cur
            while (nextTail.next!=null){
                nextTail = nextTail.next!!
            }

            nextTail.next = head
            tail.next = null
            return cur
        }
        return null;
    }

    private fun listNodeLength(head: ListNode?): Int {
        var cur = head
        var len = 0
        while (cur != null){
            len++
            cur = cur.next
        }
        return len
    }
}

class ListNode(var `val`: Int){
    var next: ListNode? = null
}

fun main(args: Array<String>) {
    val node1 = ListNode(1)
    val node2 = ListNode(2)
    val node3 = ListNode(3)
    val node4 = ListNode(4)
    val node5 = ListNode(5)
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    val rotateRight = RotateRight()
    val node = rotateRight.rotateRight(node1, 2)
    println(node)
}