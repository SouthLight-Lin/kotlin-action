package action.ch04._06

import javax.naming.Context
import javax.swing.text.AttributeSet

/**
 * Created by linnanwei on 2019/9/10
 * @author linnanwei
 */
class MyButton: View {
    constructor(ctx: Context) : super(ctx) {

    }

    constructor(ctx: Context, attr: AttributeSet)
        : super(ctx, attr){

    }
}

/**
 * 如果类没有主构造函数，那么每一个次构造函数都必须初始化基类或者委托其他做
 * 这些事的构造函数
 * */