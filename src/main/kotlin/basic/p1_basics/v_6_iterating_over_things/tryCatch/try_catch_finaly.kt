package basics.p1_basics.v_6_iterating_over_things

import java.io.BufferedReader
import java.io.StringReader

fun readNumber(reader: BufferedReader): Int? { // no checked exceptions in kotlin
    val ret = try { // try catch is en expression just like an if or when
        val line = reader.readLine() // throws checked IOException
        Integer.parseInt(line)
    } catch (e: NumberFormatException) {
        null
    } finally {
        //side effect
        reader.close() // this would have thrown a checked exception in java
    }
    return ret
}

fun main() {
    val reader = BufferedReader(StringReader("123"))
    println(readNumber(reader))
}