package kotlincore.six

/**
 * 内联函数：
 * inline：减少调用Lambda函数时生成的匿名对象，直接引用的Lambda代码被粘贴到引用出
 * noinline：避免参数被内联，与inline相反，调用Lambda函数时，还是通过匿名对象调用
 *
 * 其他用处：
 * 1、 非局部返回（inline、noinline、crossinline）
 * 2、 具体化参数类型（reified）
 * @author linnanwei
 * @since 1.0.0
 */

inline fun foo(returning: () -> Unit) {
    println("before local return")
    // 非局部返回，下面的语句将都不执行
    returning()
    println("after local return")
    return
}

fun main() {
    foo { return }
}