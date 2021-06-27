package basics.p3_classes_objects_interfaces

import org.junit.BeforeClass
import org.junit.Test
import kotlin.test.fail

internal class BoyTest {
    companion object {

        @BeforeClass
        @JvmStatic // because by default no jvm static classes are generated for companion objects
        fun setup(){
            println("some setup code that will run once b4 all tests in this class")
        }
    }

    @Test
    fun `given something, when something, then some assertion`(){
        fail("tests are fun")
    }
}