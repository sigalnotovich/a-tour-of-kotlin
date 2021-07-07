@file:JvmName("StringUtils") // annotations coming soon !

package basics.p2_extension_functions.v_3_extension_functions
//JAVA requires all code to be written as methods of classes, in real life this is not practical
// JAVA Collections static class for example ( we dont really need the class wrapper )

const val UNIX_LINE_SEPARATOR = "\n" // top level value, const means it must be assigned in compile time
// it can also be used inside annotations

fun <T> joinToString (
// java generated class will be called JoinKt.java ( corresponds to file  name )
    collection: Collection<T>,
    separator: String = ",",
    prefix: String = "[",
    suffix: String = "]"
): String {
    val res = StringBuilder(prefix)
    for ((idx, elm) in collection.withIndex()){
        if (idx > 0) res.append(separator)
        res.append(elm)
    }
    res.append(suffix)
    return res.toString()
}
