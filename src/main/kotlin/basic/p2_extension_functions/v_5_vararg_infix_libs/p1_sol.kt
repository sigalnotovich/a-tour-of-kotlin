package basics.p2_extension_functions.v_5_vararg_infix_libs

fun <T> List<T>._last(): T = this[size - 1]

fun Collection<Int>._max(): Int {
    var ret: Int? = null
    for (i in this){
        if(i > ret ?: 0){
            ret = i
        }
    }
    return ret ?: throw RuntimeException("dont call this on an empty list dude !!!")
}
