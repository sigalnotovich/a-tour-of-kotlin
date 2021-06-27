package advanced

import org.junit.Test

internal class P8_annotations_and_reflectionKtTest {
    @Test fun metaProgrammingIsFun(){
        println(
            """
                
                
                ${serializeObject(Persona("bob", 18))}
                
                
                
                """.trimIndent()
        )
    }
}