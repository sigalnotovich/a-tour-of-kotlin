package basics.p4_lambda

import java.io.File
import java.util.concurrent.Executors

// LAZY COLLECTIONS


val p = listOf(Person("Alice", 29), Person("Bob", 31), Person("Bar", 29))

val alice = people.map(Person::name).filter { it.startsWith("A") }
// map will run on all the elements in the collection


val lazyAlice = people
    .asSequence()
    .map(Person::name)
    .filter { it.startsWith("A") }
    .toList() // terminating operation - without this nothing will happen since the computation is lazy !

/*
    - sequences support same api as collections
    - use sequences on large collections !!
*/
fun callMe() {
    listOf(1, 2, 3, 4).asSequence()
        .map { print("map($it) "); it * it }
        .filter { print("filter($it) "); it % 2 == 0 }
        .toList()
}

/*
java streams and sequences are basically the same
java allows running a stream in parallel on many cores streams dont
you can use java streams in kotlin if you want
*/


// infinite sequences

val naturalNumbers = generateSequence(0) { it + 1 }
val under100 = naturalNumbers.takeWhile { it < 100 }
val s = under100.sum() // sequence termination, triggers computation


fun File.isInsideHiddenDirectory() =
    generateSequence(this) { it.parentFile }.any { it.isHidden }

val isInHidden = File("/Users/igor/.HiddenDir/a.txt").isInsideHiddenDirectory()
// isInHidden == true
// the sequences stops traversing the directory once a hidden dir is found

/*
SAM interfaces in java, single abstract method.
    - Callable
    - Runnable

kotlin automatically compiles lambdas when calling java api that accepts sam interfaces

*/
val sam = Executors.newFixedThreadPool(1).submit {
    println("this lambda is compiled into a Runnable object")
}
val sam2 = Executors.newFixedThreadPool(1).submit(object : Runnable {
    override fun run() {
        println("sort of like this")
    }
})

// THERE IS NO NEED TO USE SAM INTERFACES IN KOTLIN, FUNCTIONS HAVE PROPER TYPES !




