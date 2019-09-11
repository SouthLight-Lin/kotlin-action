package action.ch04._12

/**
 * companion object 伴生对象是声明在一个类中的常规对象
 * 类里面指向自己的实例的静态字段
 * Created by linnanwei on 2019/9/10
 * @author linnanwei
 */
class User(val nickName: String) {
    // 声明伴生对象
    companion object{
        fun newSubscribingUser(email: String) = User(email.substringBefore('@'))

        fun newFacebookUser(accountId: Int) = User("facebook_$accountId")

    }
}

fun main(args: Array<String>) {
    println(User.newSubscribingUser("linnanwei@yy.com").nickName)
    println(User.newFacebookUser(161543133).nickName)
}