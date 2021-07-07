package basics.p1_basics.v_6_iterating_over_things.maps

import java.util.*


fun main() {
    //todo: use kotlin mutable map instead
    val map = TreeMap<Char,String>() // java map
    ('A' until 'Z').forEach { char ->//todo: peek implementation of until
        map[char] = Integer.toBinaryString(
            char.toInt() // gets ascii code
        )
    }

    map.forEach { (k,v) -> // destruction similar to javascript
        println("key is: $k, val is: $v")
    }
}