package shangshou.lambda

/**
 * @author linnanwei
 * @version 1.0.0
 * @since 1.0.0
 * Date： 2020/1/20
 */

val upperCase1: (String) -> String = { str: String ->
    str.toUpperCase()
}

val upperCase2: (String) -> String = { str -> str.toUpperCase() }

val upperCase3 = { str: String -> str.toUpperCase() }

val upperCase4: (String) -> String = { it.toUpperCase() }

val upperCase5: (String) -> String = String::toUpperCase

class JsonParser {

}

operator fun JsonParser.invoke(json: String): Map<String, Any> {
    println("execute JsonParser.invoke method")
    return emptyMap()
}

fun main(args: Array<String>) {
    println(upperCase2("hello"))
    println(upperCase1("hello"))
    println(upperCase3("hello"))
    println(upperCase5("hello"))
    val parser = JsonParser()
    val map = parser("{}")
}