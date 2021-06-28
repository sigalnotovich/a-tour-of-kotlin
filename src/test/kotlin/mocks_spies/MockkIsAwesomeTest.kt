package mocks_spies

import io.mockk.*
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.impl.annotations.SpyK
import khttp.async
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import kotlin.coroutines.suspendCoroutine
import kotlin.test.assertFalse
import kotlin.test.assertTrue


///   https://mockk.io/#dsl-examples
/// EVERYTHING YOU EVER NEED IS HERE ^^^



class Car {
    fun drive(direction: String): String = "OK"
    fun drive(direction: String, speed: Int): String = "OK"

    suspend fun isGoogleAlive(query: String): Boolean {
        return suspendCoroutine { cont ->
            async.get("http://google.com?q=$query") {
                cont.resumeWith(Result.success(this.statusCode < 300)) // yield
            }
        }

    }

    fun reCharge(hours: Int): Boolean {
        return true
    }
}

internal class MockkIsAwesomeTest {
    @Test fun `mockk dsl is awesome`(){

        val car = mockk<Car>()

        every { car.drive("NORTH") } returns "OK"
        every { car.reCharge(10) } returnsMany listOf(true,true,false)

        car.drive("NORTH")
        assertTrue { car.reCharge(10)  }
        assertTrue { car.reCharge(10) }
        assertFalse { car.reCharge(10) }

        verify {
            car.drive("NORTH")
            car.reCharge(10)
        }
        confirmVerified(car)
    }
}


class CarTest {
    @MockK
    lateinit var car1: Car

    @RelaxedMockK
    lateinit var car2: Car

    @MockK(relaxUnitFun = true) // methods that return Unit dont need special prep and wont throw
    lateinit var car3: Car
    // mocks that are not relaxed throw when they are unexpectedly called
    //todo: step into Mockk annotation

    @SpyK
    var car4 = Car()

    @Before
    fun setUp() = MockKAnnotations.init(this, relaxUnitFun = true) // turn relaxUnitFun on for all mocks

    @Test
    fun `a test`() {
        // a test
    }

    @Test fun capturing(){
        val car = mockk<Car>()
        val slot = slot<Int>()
        every {
            car.drive(
                speed = capture(slot), // makes mock match call with any value for `speed` and record it in a slot
                direction = any() // any value
            )
        } answers {
            //todo: add a breakpoint here
            println(slot.captured)
            "GOOD"
        }


        car.drive(speed = 15, direction = "NORTH")

        verify(exactly = 1) { car.drive(speed = or(15, 16), direction = any()) }
        confirmVerified(car)
    }


    @Test fun `test co routines`(){
        val car = mockk<Car>()
        coEvery { car.isGoogleAlive("banana") } returns true

        runBlocking {
            car.isGoogleAlive("banana")
        }

        coVerify {
            car.isGoogleAlive("banana")
        }
    }

}

