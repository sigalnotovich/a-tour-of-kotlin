package basics.p1_basics.v_6_iterating_over_things

// use idea to jump to project view
// back to editor


fun main() {

    for (i in 1..100) println(fizBuzz(i)) // inclusive
    for (i in 1 until 100) println(fizBuzz(i)) // exclusive
    //todo: use idea to convert to a function call,
    // add indices to for loop with idea
    // show hide idea preview of auto refactor step
    for (i in 100 downTo 1) println(fizBuzz(i))

    (1..100).forEach { println(fizBuzz(it)) } // whats this magic syntax ??

    //while, and do-while loops are just like java

}


fun fizBuzz(i: Int) = when {
    i % 15 == 0 -> "fizzBuzz"
    i % 3 == 0 -> "fizz"
    i % 5 == 0 -> "buzz"
    else -> "$i"
}



