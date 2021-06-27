package basics.p2_extension_functions.v_5_vararg_infix_libs

fun main(args: Array<String>) {
    val lst = listOf("args: ", *args) // spread operator with a fixed value, (This isn’t supported in Java).
    println(lst) //todo: pass command line args using IDEA configuration
}