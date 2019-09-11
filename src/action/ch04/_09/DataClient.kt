package action.ch04._09

/**
 * 数据类
 * 添加data修饰符，所有必要的方法将自动生成
 * 比如equals、toString、hashCode
 * Created by linnanwei on 2019/9/10
 * @author linnanwei
 */
data class DataClient(val name: String, val postalCode: Int)


fun main(args: Array<String>) {
    val client = DataClient("lnw", 1242)
}