package action.ch04._09

/**
 * Created by linnanwei on 2019/9/10
 * @author linnanwei
 */
class Client(val name: String, val postalCode: Int) {
    override fun toString(): String {
        return "Client(name=$name, postalCode=$postalCode)"
    }

    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Client){
            return false
        }

        return name == other.name && postalCode == other.postalCode
    }

    override fun hashCode(): Int {
        return name.hashCode() * 31 +  postalCode
    }

    fun copy(name: String = this.name,
             postalCode: Int = this.postalCode) =
        Client(name, postalCode)
}

fun main(args: Array<String>) {
    val bob = Client("Bob", 989291)
    println(bob.copy(postalCode = 39902))
}