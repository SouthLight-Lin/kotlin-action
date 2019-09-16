package action.ch07

/**
 * Created by linnanwei on 2019/9/12
 * @author linnanwei
 */
data class Point(val x: Int, val y: Int){
    /** 重载 **/
    override fun equals(other: Any?): Boolean {
        if (other === this) return true      //使用恒等运算符来检查参数，与调用equals的对象是否相同
        if (other !is Point) return false
        return other.x == x && other.y == y
    }
}


