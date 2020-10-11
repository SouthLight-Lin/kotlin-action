package kotlincore.nine

/**
 * 用单例替代工厂类
 *
 * @author linnanwei
 * @since 1.0.0
 */
object ComputerFactory {
    fun produce(type: ComputerType): Computer {
        return when (type) {
            ComputerType.PC -> PC()
            ComputerType.Server -> Server()
        }
    }

    operator fun invoke(type: ComputerType): Computer {
        return when (type) {
            ComputerType.PC -> PC()
            ComputerType.Server -> Server()
        }
    }
}

fun main() {
    // 但是这里produce方法又显得多余，所有可以使用operator操作符重载完善
    ComputerFactory.produce(ComputerType.Server)
    ComputerFactory.produce(ComputerType.PC)

    // better code
    ComputerFactory(ComputerType.PC)
    ComputerFactory(ComputerType.Server)
}