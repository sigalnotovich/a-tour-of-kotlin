package mocks_spies

import io.mockk.*
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.impl.annotations.SpyK
import org.junit.Before
import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Car {
    fun drive(direction: String): String {
        return "OK"
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


class TrafficSystem {
    lateinit var car1: Car

    lateinit var car2: Car

    lateinit var car3: Car
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

    @InjectMockKs
    var trafficSystem = TrafficSystem()

    @Before
    fun setUp() = MockKAnnotations.init(this, relaxUnitFun = true) // turn relaxUnitFun on for all mocks

    @Test
    fun calculateAddsValues1() {
        // ... use cars
    }
}