package algorithm

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
        val idx = partition(arr, left, right)
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

    private fun swap(arr: Array<Int>, i: Int, j: Int):Unit{
        var tmp = arr[i]
        arr[i] = arr[j]
        arr[j] = tmp
    }


}

fun main(args: Array<String>) {
    val quickSort = QuickSort();
    var arr = arrayOf(1,2,3,4,5)
    println(quickSort.partition(arr,0, arr.size-1))
//    println(quickSort.sort(arr))
//    for (i in arr) {
//        print("$i ")
//    }

}