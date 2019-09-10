package algorithm
var opCount = 0
/**
 * Created by linnanwei on 2019/9/5
 * @author linnanwei
 */
class QuickSort {

    fun sort(arr: Array<Int>){
        if (arr == null || arr.size <=1 ){
            return
        }
        helper(arr, 0 , arr.size-1)
    }

    private fun helper(arr: Array<Int>, left: Int, right: Int){
        if (left >= right)
            return
        val idx = partition2(arr, left, right)
        helper(arr, left, idx-1)
        helper(arr, idx+1, right)
    }

    fun partition(arr: Array<Int>, left: Int, right: Int): Int{
        var lo = left
        var hi = right+1
        var pivot = arr[left]
        while(true){
            while((++lo) < right && arr[lo] <= pivot);
            while ((--hi) > left && arr[hi] > pivot);
            if (lo >= hi)
                break
            swap(arr, lo, hi)
        }
        swap(arr, hi, left)
        return hi
    }

    fun partition2(arr: Array<Int>, start: Int, end: Int): Int {
        val pivot = arr[start]
        var idx = start + 1
        for (i in start + 1..end) {
            if (arr[i] < pivot) {
                swap(arr, i, idx)
                idx++
            }
        }
        swap(arr, start, idx - 1)
        return idx - 1
    }

    private fun swap(arr: Array<Int>, i: Int, j: Int):Unit{
        var tmp = arr[i]
        arr[i] = arr[j]
        arr[j] = tmp
        opCount++;
    }
}

fun main(args: Array<String>) {
    val quickSort = QuickSort();
    var arr = arrayOf(1,2,3,4,5)
//    println(quickSort.partition(arr,0, arr.size-1))
    quickSort.sort(arr)
    println(opCount)
    //    println(quickSort.sort(arr))
    for (i in arr) {
        print("$i ")
    }

}