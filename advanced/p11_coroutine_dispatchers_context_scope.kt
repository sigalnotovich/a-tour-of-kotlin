package advanced

import khttp.async
import khttp.responses.Response
import kotlinx.coroutines.*
import java.util.concurrent.Executors
import kotlin.coroutines.suspendCoroutine

/*
                    every coroutine must be executed in a context
                    a context contains stuff
                    most important:
                    - job
                    - dispatcher
                                the dispatchers confines the coroutine to a thread / thread pool
 */

fun dispatchers() {
    runBlocking {
        val dispatcher = Executors.newFixedThreadPool(10).asCoroutineDispatcher()
        launch(dispatcher) {
            // something
        }
        launch(Dispatchers.Unconfined) { // main thread
            // something
        }
        launch {  }

        /*
            since launch is an extension function on coroutine scope | it "inherits" its context, thus dispatcher.
            the third launch gets the scope from runBlocking that uses the main thread
            the second launch uses same thread as caller thread
        */

        val parent = launch {
            val child1 = launch {  }
            val child2 = launch {  }
        }
    }
    /*
        every co-routine called from another co-routine become a child of the parent job
        the parent dots not have to do child.join() on all of his children
        parent.join()
        will wait for all children completion
     */
}


//                      CO-ROUTINE SCOPE
fun scope(){
    val scope = MainScope()
    scope.launch {

    }
    scope.cancel()

    // essentially a wrapper around context
    // used for type safe building ( structured concurrency )
    // manages life cycle of co-routines
    // when its canceled, all child co-routines will be canceled and no new will be created
}

fun callbackToACoRoutine()  = runBlocking {
    val resp = asyncHttpReq()
    println(resp.statusCode)
    println(resp.text)
}

suspend fun asyncHttpReq(): Response {
    return suspendCoroutine { cont ->
        async.get("http://httpbin.org/get") {
            cont.resumeWith(Result.success(this))
        }
    }
}
