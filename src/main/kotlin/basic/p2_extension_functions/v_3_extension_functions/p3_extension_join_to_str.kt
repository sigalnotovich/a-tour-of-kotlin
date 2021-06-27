package basics.p2_extension_functions.v_3_extension_functions

fun <T> Collection<T>.joinToString(
    separator: String = ",",
    prefix: String = "[",
    suffix: String = "]"
): String {
    val res = StringBuilder(prefix)
    for ((idx, elm) in this.withIndex()){ //todo: use IDEA to replace with a function call, what do you prefer
        if (idx > 0) res.append(separator)
        res.append(elm)
    }
    res.append(suffix)
    return res.toString()
}


fun run1() {
    listOf(1,2,3).joinToString(" ")
    // 1 2 3
}


fun Collection<String>.join(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
) = joinToString(separator, prefix, postfix)

// can be invoked only on a collection of strings