package advanced

import kotlinx.coroutines.*

/* check out more jetbrains coroutine examples

https://github.com/Kotlin/kotlinx.coroutines/tree/master/kotlinx-coroutines-core/jvm/test/guide

            good stuff ^^^
 */




fun main() = runBlocking { // todo: use idea ctrl+j to quick read docs of runBlocking, lunch and delay
    launch {
        delay(1000L)
        println("Hello")
    }
    println("World!")
}

//what will print first ?

// todo: try calling banana from main, without runBlocking
suspend fun manyParallel() = coroutineScope {  // read docs
    repeat(100_000) {
        launch {
            println(".")
        }
    }
}

// do all jobs run in parallel ?
// will launching 100K co routines make your machine die ?
// what about 100K threads ?

//todo: use idea to fund usages
suspend fun runCoRoutine() = coroutineScope { // type safe builder - co routine DSL
    launch {
        delay(2000L)
        println("2")
    }
    launch {
        delay(1000L)
        println("1")
    }
    println("0")
}

suspend fun whoCancelsMe() = coroutineScope {
    val job = launch {
        repeat(100) { i ->
            println("$i")
            delay(500L)
        }
    }
    delay(1300L)
    println("nu")
    job.cancelAndJoin()
}

suspend fun cooperativeCancellation() = coroutineScope {
    val job = launch {
        repeat(100) {
            println("loop: $it ")
        }
    }
    delay(1300L)
    println("nu")
    job.cancelAndJoin()
}


suspend fun finallyInCoRoutine() {
    val job = GlobalScope.launch { //todo: ctrl+j omn GlobalScope --> this creates mem leaks, easy !!!
        try {
            repeat(1000) { i ->
                println("$i")
                delay(100L)
            }
        } finally {
            println("finally")
        }
    }
    delay(200L)
    job.cancelAndJoin()
    //todo: will finally happen ?
}


suspend fun timeout(){
    withTimeout(100){
        repeat(11){
            println("$it")
            delay(1)
        }
    }
}

fun structuredConcurency(){
    suspend fun one(): Int {
        delay(500L)
        println("one")
        return 13
    }

    suspend fun two(): Int {
        delay(100L)
        println("two")

        return 29
    }

    runBlocking {
        one()
        two()
        // will happen sequentially ( no async jobs created )

        val a = async(start = CoroutineStart.LAZY) { one() } // will be computed only on a call to await
        val b = async { two()  }
        // creates to concurrent async jobs
        // todo: whats the difference between an async and launch ?
        // todo: what happen if the first 'one' throws an exception ?
        // todo: what happens in runBlocking if no one does await on b ?
        // todo: what will happen if second async block will throw an exception ?
    }

}

// Cancellation (exceptions) is always propagated through coroutines hierarchy