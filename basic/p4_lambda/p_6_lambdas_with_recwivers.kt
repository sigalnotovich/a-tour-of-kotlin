package basics.p4_lambda

// perform multiple operations on the same object without repeating its name


//                                  with
fun alphabet(): String {
    val result = StringBuilder()
    for (letter in 'A'..'Z') {
        result.append(letter)
    }
    result.append("\nNow I know the alphabet!")
    return result.toString()
}

fun alphabet2(): String {
    val result = StringBuilder()
    return with(result) {
        for (letter in 'A'..'Z') {
            append(letter)
        }
        append("\nNow I know the alphabet!")
        toString()
    }
}

//extension function is, in a sense, a function with a receiver

fun alphabet3(): String {
    return with(StringBuilder()) {
        for (letter in 'A'..'Z') {
            append(letter)
        }
        append("\nNow I know the alphabet!")
        toString()
    }
}


//                                          apply
fun alphabet4(): String {
    return StringBuilder().apply {
        for (letter in 'A'..'Z') {
            append(letter)
        }
        append("\nNow I know the alphabet!")
    }.toString() //  notice that toString is located outside tha apply closure
    // since apply returns the receiver
}

// you’re creating an instance of an object and need to initialize some properties right away.


fun alphabet5() = buildString { //buildString is an stdlib function
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know the alphabet!")
}
//todo: step into buildString and checkout its signature