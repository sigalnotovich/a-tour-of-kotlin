package advanced

import java.io.BufferedReader
import java.io.FileReader
import java.util.concurrent.locks.Lock

inline fun <T> synchronized(lock: Lock, action: () -> T): T {
    lock.lock()
    try {
        return action() // action will also be inlined if its known in compile time
    }
    finally {
        lock.unlock()
    }
}

/*
    the inline keyword will cause the compiler to
    substitute the code directly into places where the function is called
    instead of being invoked normally

    in real life, use kotlin 'withLock' stdlib function instead
*/

val e = listOf(1,2,3).filter { it == 1 }
/*
    filter is inlined, performance reasons ( uses less ram, less objects to create )

    use inline funcs only for functions that accepts lambdas as params
    the rest is already optimized by JIT
*/




//                non local return

fun readLine(path: String): String {
    BufferedReader(FileReader(path)).use { // the 'use' function makes sure file is closed. inlined for performance reasons
        return it.readLine() // return from readLine
    }
}

/*
        Putting a return statement in the middle of a for loop is a no-brainer.
        But what if you convert the loop into the use of a function such as filter ?
*/

fun example5(predicate: (Int) -> Boolean): Int? {
    for (i in (1..100)) {
        if (predicate(i))
            return i // returning from a for loop
    }
    return null
}

fun example6(predicate: (Int) -> Boolean): Int? {
    (1..100).forEach { i ->
        if (predicate(i))
            return i // return returns from the closest function declared using the 'fun' keyword
    }
    return null
}

fun example7(predicate: (Int) -> Boolean): Int? {
    return (1..100).find label@{ i -> // labeling the lambda
        return@label predicate(i)
    }
    // dont use this in real life.
}

fun example8(predicate: (Int) -> Boolean): Int? {
    return (1..100).find(fun (x: Int): Boolean { // anonymous function, return works as usual
        return predicate(x)
    })
}

