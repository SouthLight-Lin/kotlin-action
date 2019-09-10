package action.ch03

import java.lang.IllegalArgumentException

/**
 * 存储User对象前，判空
 * 使用本地函数
 * Created by linnanwei on 2019/9/10
 * @author linnanwei
 */

class User(val id: Int, val name: String, val address: String)

/** 扩展User对象方法 **/
fun User.validateBeforeSave(){
    /** 本地函数，来验证任意字段 **/
    fun validate(value: String, fileName: String){
        if (value.isEmpty()){
            throw IllegalArgumentException("Can't save user $id: empty $fileName")
        }
    }

    validate(name, "Name")
    validate(address, "Address")
}
fun saveUser(user: User){
    // 调用扩展函数
    user.validateBeforeSave()
    // Save user to the database
    // ...
}

fun main(args: Array<String>) {
    saveUser(User(1,"", ""))
}