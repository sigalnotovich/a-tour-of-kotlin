package basics.p2_extension_functions.v_2_joinToString

val collection = listOf(1, 2, 3)
fun run() {
    println(
        joinToString(collection, " ", " ", ".")
    )

    // how to make it less verbose ?
    // what parameters all these Strings correspond to ????
    /* Java */
//          joinToString(collection, /* separator */ " ",  /* prefix */ " ", /* postfix */ ".");
    // Maybe you could avoid having to pass four arguments every time you call the function ?
}


fun run1() {
    joinToString(collection, separator = " ", prefix = " ", postfix = ".")
    //todo: try renaming one of joinToString args using IDEA
    //named args works only when calling kotlin code :(
}

fun <T> joinToString_v2(
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

fun run2() {
    println(
        joinToString_v2(collection)
    ) //        1, 2, 3
    println(
        joinToString_v2(collection,";")
    ) //        1; 2; 3
    println(
        joinToString_v2(list, suffix = ";", prefix = "# ")
    ) //        # 1, 2, 3;
}
