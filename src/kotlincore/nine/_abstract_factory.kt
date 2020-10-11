package kotlincore.nine

/**
 * 抽象工厂
 * @author linnanwei
 * @since 1.0.0
 */
interface ComputerCompany

class Dell : ComputerCompany
class Asus : ComputerCompany
class Acer : ComputerCompany

class DellFactory : AbstractFactory() {
    override fun produce() = Dell()
}

class AsusFactory : AbstractFactory() {
    override fun produce() = Asus()
}

class AcerFactory : AbstractFactory() {
    override fun produce() = Acer()
}

abstract class AbstractFactory {
    abstract fun produce(): ComputerCompany

    companion object {
        inline operator fun <reified T : ComputerCompany> invoke(): AbstractFactory =
                when (T::class) {
                    Dell::class -> DellFactory()
                    Asus::class -> AsusFactory()
                    Acer::class -> AcerFactory()
                    else -> throw IllegalArgumentException()
                }
    }
}

fun main() {
    val dellFactory = AbstractFactory<Dell>()
    println(dellFactory.produce())
}