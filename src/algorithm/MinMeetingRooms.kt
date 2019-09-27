package algorithm

import java.util.*
import kotlin.Comparator

/**
 * @author linnanwei
 * @version 1.0.0
 * @since 1.0.0
 * Date： 2019/9/27
 */

/**
 * 解法一：使用最小堆记录最小截止会议时间，每次要开会时就比较一下最小截止时间
 */
fun minMeetingRooms(intervals: Array<IntArray>): Int{
    if (intervals.isEmpty()){
        return 0
    }

    Arrays.sort(intervals) { o1, o2 ->
        o1[0] -  o2[0]
    }

    val pq = PriorityQueue<Int>()

    pq.offer(intervals[0][1])

    for(i in 1 until intervals.size){
        // 如果结束时间小于等于下个会议的开始时间，不用新开会议室
        if (pq.peek() <= intervals[i][0]){
            pq.poll()
        }

        pq.offer(intervals[i][1])
    }

    return pq.size
}

/**
 * 解法二：不用使用辅助结构，将会议的起始时间和终止时间分成两组，分别排序
 *          遍历起始时间数组，看终止时间数组是否有会议结束
 */
fun minMeetingRooms2(intervals: Array<IntArray>): Int{
    if (intervals.isEmpty()){
        return 0
    }

    val n = intervals.size

    val start = IntArray(n)
    val end = IntArray(n)

    for (i in 0 until n){
        start[i] = intervals[i][0]
        end[i] = intervals[i][1]
    }

    // 将两个数组排序
    Arrays.sort(start)
    Arrays.sort(end)

    var s = 0
    var e = 0

    while (s < n){
        if (end[e] <= start[s]){
            e++;
        }
        s++;
    }

    return s-e
}


fun main() {
    val data = Array<IntArray>(2) { IntArray(2) {0} }
    val array1 = intArrayOf(7, 10)
    val array2 = intArrayOf(2, 4)
//    val array3 = intArrayOf(15, 20)
    data[0] = array1
    data[1] = array2
//    data[2] = array3

    println(minMeetingRooms2(data))
}