package basics.p1_basics.v_4_enums_when_expr

import java.util.*

enum class EnumExample {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
}

enum class Color(val r: Int, val g: Int, val b: Int) {
    RED(255, 0, 0),
    ORANGE(1, 1, 1),
    YELLOW(2, 2, 2),
    GREEN(3, 3, 3),
    BLUE(4, 4, 4),
    INDIGO(5, 5, 5),
    VIOLET(6, 6, 6); // OMG a semicolon !!!

    fun rgb() = (r * 256 * g) * 256 + b
}


fun main() {
    println(Color.BLUE.rgb())
    println(Color.BLUE.ordinal) // order
    println(Color.BLUE > Color.RED) // ordered
}

//todo: 5 add to hebrew method, use IDEA to complete all cases
fun getAlias(color: Color) = when(color){
    Color.RED -> "krasni"
    Color.ORANGE -> "oranjivi"
    Color.YELLOW -> "jolti"
    Color.GREEN -> "zelioni"
    Color.BLUE -> "sini"
    Color.INDIGO -> "??"
    Color.VIOLET -> "serenivi"
}


fun getWarmth(color: Color): String {
    //todo: 6 remove green and see what the compiler thinks.
    return when(color){
        Color.RED, Color.ORANGE, Color.YELLOW -> "warm"
        Color.GREEN -> "mix"
        Color.BLUE, Color.INDIGO,  Color.VIOLET -> "cold"
    }
}

//todo: 7 add a code block that logs something for each finger
fun mix(c1: Color, c2: Color): Color = when (setOf(c1, c2)) { // calls equals
    setOf(Color.RED, Color.ORANGE) -> Color.ORANGE
    setOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
    else -> throw RuntimeException("duck")
}
// expression body dont require to use the 'return' key word
// koltin is statically typed, no need to explicitly define the return type

fun randomPrint() {
    val rand = Random().nextInt()

    //todo: 8 convert to when using IDEA
    //todo: 9 convert back to if using idea
    if (rand % 2 == 0){
        println("$rand is Even")
    } else if (rand % 3 == 0) {
        println("$rand is divided by 3")
    } else if (rand % 4 == 0) {
        println("$rand is divided by 4")
    } else if (rand % 5 == 0) {
        println("$rand is divided by 5")
    } else if (rand % 6 == 0) {
        println("$rand is divided by 6")
    }

}