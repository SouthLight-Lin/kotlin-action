package action.ch04._10

import java.util.ArrayList

/**
 * 类委托：by关键字
 * 每当实现一个借口，通过by关键字把接口的实现委托给另一个对象
 * Created by linnanwei on 2019/9/10
 * @author linnanwei
 */
class DelegatingCollection<T>(
    innerList: Collection<T> = ArrayList<T>()
): Collection<T> by innerList{}

/**
 * DelegatingCollection的行为都委托给ArrayList
 * 通过by关键字，编译器可以自动为你生成响应的方法
 * */