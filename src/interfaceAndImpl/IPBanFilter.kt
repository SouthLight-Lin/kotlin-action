package interfaceAndImpl

/**
 * @author linnanwei
 * @version 1.0.0
 * @since 1.0.0
 * Date： 2019/10/8
 */
class IPBanFilter() : BanFilter {

    var localName = ""

    override var banFilterName: String
        get() = localName
        set(value) {}

    init {
        localName = "ipBanFilter"
    }

}

fun main(args: Array<String>) {
    val ipBanFilter = IPBanFilter()
    println(ipBanFilter.banFilterName)
}