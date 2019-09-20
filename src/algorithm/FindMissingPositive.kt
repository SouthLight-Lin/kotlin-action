package algorithm

/**
 * 输入一个数组，找到第一个缺失的数
 *
 * 输入: [1,2,0]
 * 输出: 3
 *
 * 输入: [3,4,-1,1]
 * 输出: 2
 *
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * Created by linnanwei on 2019/9/20
 * @author linnanwei
 */

class FindMissingPositive{
    fun findMissingPositive(arr:IntArray): Int{
        if (arr.isEmpty()){
            return 1;
        }
        var i = 0;
        while (i < arr.size){
            var tmpI = i;
            /** 三个循环条件 **/
            // 1、 下标i必须在数组范围内，因为有可能数值为-1
            // 2、arr[i]的值必须在数组范围内
            // 3、满足前两个条件后，接下来必须满足 i != arr[i]-1
            while (i >= 0 && i<arr.size && i != arr[i]-1 && arr[i] > 0 && arr[i] < arr.size){
                val value = arr[i];
                swap(arr, i, value-1)
            }
            i = ++tmpI;
        }

        for (i in 0 until arr.size){
            if (arr[i]!=(i+1)){
                return i+1;
            }
        }

        return arr.size+1;
    }

    fun swap(arr: IntArray, i: Int, j:Int){
        val tmp = arr[i]
        arr[i] = arr[j]
        arr[j] = tmp
    }
}

fun main(args: Array<String>) {
    val arr = intArrayOf(7,8,9,11,12)
    println(FindMissingPositive().findMissingPositive(arr))
}