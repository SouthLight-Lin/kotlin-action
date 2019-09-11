package action.ch04._06

/**
 * 主构造函数
 * Created by linnanwei on 2019/9/10
 * @author linnanwei
 */
/**
 * constructor开启一个主构造器或次构造器的声明
 * init引入一个initializer块，包含这个类通过主构造函数创建时
 * 执行的初始化代码块
 */
// "val"意味着对应的属性是为构造参数生成的
open class User (val nickName: String, val isSubscribed: Boolean = true)

class TwitterUser(nickName: String): User(nickName)

open class Button  //生成没有一个参数的默认构造函数

// 这个类有一个私有构造函数
class Secretive private constructor(){}