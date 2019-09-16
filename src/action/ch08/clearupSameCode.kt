package action.ch08

/**
 * 消除重复代码
 * @author SouthLight-Lin on 2019/9/16
 */
data class SiteVisit(val path: String, val duration: Double, val os: OS)

enum class OS{WINDOWS, LINUX, MAC, IOS, ANDROID}

val log = listOf<SiteVisit>(SiteVisit("/", 34.0,OS.WINDOWS),
        SiteVisit("/", 32.0,OS.MAC),
        SiteVisit("/login", 12.0,OS.WINDOWS),
        SiteVisit("/signup", 8.0,OS.IOS),
        SiteVisit("/", 16.3,OS.ANDROID))

val averageWindowsDuration = log.filter { it.os == OS.WINDOWS }
        .map (SiteVisit::duration)
        .average();
/** 上面的方法只能做到计算Windows的，为了扩展性，我们需要Lambda消除重复代码 **/
fun List<SiteVisit>.averageDurationFor(os: OS) =
        filter { it.os == os }.map(SiteVisit::duration).average();

fun main(args: Array<String>) {
    println(averageWindowsDuration)
    println(log.averageDurationFor(OS.WINDOWS))
    println(log.averageDurationFor(OS.MAC))
}