package basics.p1_basics.v_6_iterating_over_things

fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
fun isNotDigit(c: Char) = c !in '0'..'9'
fun isKotlin(lang: String) = lang !in setOf("JAVA","GOLANG","TYPESCRIPT") //todo: 10 use idea to step into `in` operator

