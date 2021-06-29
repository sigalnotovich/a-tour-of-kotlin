package advanced

//          Function types

val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }


fun highOrderFun(num: Int, transform: (Int) -> Int): () -> Int {
    return { transform(num) } //thunk
}
// functional argument / functional return type

val one = highOrderFun(1) { it * it }()


fun String.filter(predicate: (Char) -> Boolean): String =
    buildString {
        this@filter.forEach { char ->
            if (predicate(char)) append(char)
            //this@filter access the this of filter extension func and not buildString
        }
    }

val aaa = "ababa".filter { it == 'a' }


fun <T> joinToString(
    collection: Collection<T>,
    separator: String,
    prefix: String,
    postfix: String,
    transform: (T) -> String = { x -> "__${x.toString()}__" } // generic functional with default value
): String = buildString {
    append(prefix)
    collection.withIndex().forEach { (idx, elm) ->
        if (idx > 0) append(separator)
        append(transform(elm))
    }
    append(postfix)
}

val joined = joinToString(listOf(1, 2, 3), prefix = "[", postfix = "]", separator = ",") { "$it" }
// ["__1__","__2__","__3__"]




val predicate = { it: Char -> it == 'b' }.concat { it == 'c' }
val bbc = "ababac".filter(predicate)

fun ((Char) -> Boolean).concat(f: (Char) -> Boolean): (Char) -> Boolean = { it ->
    invoke(it) && f(it) // invoke calls the 'this' function
}
