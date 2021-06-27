package basics.p5_type_system

import org.junit.Before
import org.junit.Test
import kotlin.test.assertNotNull

internal class LateInitTest  {

    lateinit var person: Person

    @Before fun setup(){
        person = Person("")
    }


    @Test fun personIsNotNull(){
        assertNotNull(person.name) // no need to !!
    }
}