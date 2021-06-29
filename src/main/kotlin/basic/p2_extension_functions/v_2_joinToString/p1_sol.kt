package basics.p2_extension_functions.v_2_joinToString


fun <T> joinToString(
    collection: Collection<T>,
    separator: String,
    prefix: String,
    postfix: String
): String {
    val res = StringBuilder(prefix)
    for ((idx, elm) in collection.withIndex()){
        if (idx > 0) res.append(separator)
        res.append(elm)
    }
    res.append(postfix)
    return res.toString()
}

 val x  = joinToString(list, "; ", "(", ")")