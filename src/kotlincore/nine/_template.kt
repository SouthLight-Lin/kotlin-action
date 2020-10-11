package kotlincore.nine

/**
 * 模板方法模式
 *
 * @author linnanwei
 * @since 1.0.0
 */
/** 市民事务中心办事Demo */
abstract class CivicCenterTask {
    fun execute() {
        lineUp()
        askForHelp()
        evaluate()
    }

    /** 排队取号等待 */
    private fun lineUp() {
        println("line up to take a number")
    }

    /** 对本次服务进行评价 */
    private fun evaluate() {
        println("evaluate service attitude")
    }

    abstract fun askForHelp()
}

/** 社保问题 */
class PullSocialSecurity: CivicCenterTask() {
    override fun askForHelp() {
        println("ask for pulling the social security")
    }
}
/** 申请市民卡 */
class ApplyForCitizenCard: CivicCenterTask() {
    override fun askForHelp() {
        println("apply for a citizen card")
    }
}

/** 利用高阶函数简化模板模式 **/
class CivicCenterTaskLambda {
    fun execute(askForHelp:() -> Unit) {
        lineUp()
        askForHelp()
        evaluate()
    }

    /** 排队取号等待 */
    private fun lineUp() {
        println("line up to take a number")
    }

    /** 对本次服务进行评价 */
    private fun evaluate() {
        println("evaluate service attitude")
    }
}
fun pullSocialSecurity() {
    println("ask for pulling the social security")
}
fun applyForCitizenCard() {
    println("apply for a citizen card")
}

fun main() {
    val pss = PullSocialSecurity()
    pss.execute()

    val afcc = ApplyForCitizenCard()
    afcc.execute()

    val task1 = CivicCenterTaskLambda()
    task1.execute(::pullSocialSecurity)
}