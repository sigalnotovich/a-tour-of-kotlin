package basics.p2_extension_functions

val set = hashSetOf(1, 7, 53)
val list = arrayListOf(1, 7, 53)
val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")

fun main() {
    println(set.javaClass)
    println(list.javaClass)
    println(map.javaClass)
    // Kotlin uses the standard Java collection classes, unlike scala.
    //Everything you know about java collections still applies

    println(
        list.maxOrNull() // prints 53. If list is a java Array list, where maxOrNull comes from ?
    )
    println(
        list.last() // prints 53. If list is a java Array list, where list comes from ?
    )
}