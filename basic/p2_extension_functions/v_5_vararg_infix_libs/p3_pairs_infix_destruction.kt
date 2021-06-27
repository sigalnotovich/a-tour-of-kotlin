package basics.p2_extension_functions.v_5_vararg_infix_libs

//infix call
//todo: step into `to` implementation
val map = mapOf(
    1 to "one",
    7 to "seven",
    53 to "fifty-three"
) // this is a regular function ( not special syntax or anything like that )

//todo: write an infix extension function that will concat arrays


fun destruction() {
    val (number, name) = 1 to "one"
    // javascript is awesome
    // you have seen destruction already in for loops
}



fun <K, V> _mapOf(vararg values: Pair<K, V>): Map<K, V>{
    TODO("implement me at home")
}