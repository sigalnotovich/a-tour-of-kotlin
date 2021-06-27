package basics.p1_basics.v_1_methodsAndVariables

//top level variables
// val comes from value
val question =
    "The Ultimate Question of Life, the Universe, and Everything"

val answer = 42

val _answer: Int = 42
val yearsToCompute = 1.2e6
val _yearsToCompute = 1_200_000

// var comes from variable
var da = "da"
fun setDa() {
    da = ""
}

// you should strive to declare all variables in Kotlin with the val keyword.

fun settingVal() {
    val message: String
    if (canPerformOperation()) {
        message = "Success"
        // ... do somehting
    }
    else {
        message = "Failed"
    }

}

fun canPerformOperation() = true




val array = mutableListOf("")
fun updateArray() {
    // val means array variable is immutable, not the value it points to
    array.add("banana")
}
