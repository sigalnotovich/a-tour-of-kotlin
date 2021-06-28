package functional

import org.junit.Test

internal class P1_functorsKtTest{

    @Test fun `functions are fun`(){
            val l: Identity<List<Char>> = composed()
    }

    @Test fun `functions are super fun`(){
        val empty = mapEmpty()
        println(empty)
    }

    @Test fun `looks familiar`(){
        println(
            flist()
        )
    }

    @Test fun `flat`(){
        val fOptional = flattened()
        println(
            fOptional
        )
        println(
            flattenEmpty()
        )
    }

}