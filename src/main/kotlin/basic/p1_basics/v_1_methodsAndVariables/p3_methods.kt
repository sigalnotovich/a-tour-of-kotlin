package basics.p1_basics



// trinary if
// if is an expression, so do try catch, and when
// use idea to convert expression body
fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}

// inline body
// no need to explicitly declare return type
// no need to use the "return" keyword
fun max(a: Long, b: Long) = if (a > b) a else b

