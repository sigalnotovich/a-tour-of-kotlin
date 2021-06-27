package advanced

import kotlinx.coroutines.runBlocking
import org.junit.Test


internal class P10_coroutinesKtTest {

    @Test fun run100K() = runBlocking {
        manyParallel()
        println("done")
        // dont try this with threads
    }

    @Test
    fun `run two parallel and wait until both done`() {
        runBlocking {
            runCoRoutine() // runCoRoutine completes only after all child co routines complete
            println("done")
        }
    }


    @Test fun `cancel a coroutine 1`() = runBlocking {
        whoCancelsMe()
    }

    @Test fun `cancel a coroutine 2`() = runBlocking {
        cooperativeCancellation()
    }
    // why cancel a coroutine 1 did not run 100 times ?
    @Test fun `finally in co routine`() = runBlocking {
            finallyInCoRoutine()
    }

    @Test fun `structured coroutines`(){
        structuredConcurency()
    }
}
