package kotlincore.nine


/**
 * @author linnanwei
 * @since 1.0.0
 */
interface Computer {
    val cpu: String

    /** 伴生对象创建静态共产 */
    companion object {
        operator fun invoke(type: ComputerType): Computer {
            return when (type) {
                ComputerType.PC -> PC()
                ComputerType.Server -> Server()
            }
        }
    }
}

class PC(override val cpu: String = "core"): Computer
class Server(override val cpu: String = "Xeon"): Computer

enum class ComputerType {
    PC, Server
}

/**
 * 创建Computer工厂类
 * 但是创建对象上不够优雅，需要先实例ComputerFactory在调用produce方法
 */
//class ComputerFactory {
//    fun produce(type: ComputerType): Computer {
//        return when(type) {
//            ComputerType.PC -> PC()
//            ComputerType.Server -> Server()
//        }
//    }
//}