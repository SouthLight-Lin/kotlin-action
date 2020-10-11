package kotlincore.nine

/**
 * 具名可选参数，require验证参数
 *
 * @author linnanwei
 * @since 1.0.0
 */
class Robot(
        val code: String,
        val battery: String? = null,
        val height: Int? = null,
        val weight: Int? = null
) {
    init {
        require(weight == null || battery != null) {
            "Battery should be determined when setting weight."
        }
    }
}

fun main() {
    val robot = Robot(code = "007", weight = 100)
}