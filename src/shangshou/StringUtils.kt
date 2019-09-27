package shangshou

/**
 * 伴生对象
 * Created by linnanwei on 2019/9/23
 * @author linnanwei
 */
class StringUtils {
    companion object{
        fun isEmpty(str: String): Boolean{
            return str.isEmpty();
        }
    }
}

/** 利用伴生对象生成单例 **/
class Single private constructor(){
    companion object{
        fun get(): Single{
            return Holder.instance
        }
    }

    private object Holder{
        val instance = Single()
    }
}
fun main(args: Array<String>) {
    StringUtils.isEmpty("")
}