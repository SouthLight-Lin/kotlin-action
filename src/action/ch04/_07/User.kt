package action.ch04._07

/**
 * Created by linnanwei on 2019/9/10
 * @author linnanwei
 */
interface User {
//    val email: String
    val nickName: String
//        get() = email.substringBefore('@')
}

// 意味着实现User接口的类需要提供一种方式来和获取nickName的值