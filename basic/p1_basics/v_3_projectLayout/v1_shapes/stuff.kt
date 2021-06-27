package basics.p1_basics.v_3_projectLayout // package declaration
import java.util.*

class Rectangle(val height: Int, val width: Int){
    val isSquare: Boolean
        get() = height == width
}

fun createRandomRect() : Rectangle {
    val rand = Random()
    return Rectangle(rand.nextInt(),rand.nextInt())
}
