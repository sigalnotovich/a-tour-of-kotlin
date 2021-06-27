package advanced

import kotlin.math.sqrt

data class X(val x: Int, val y: Int) {
    operator fun plus(other: X) = Point(x + other.x, y + other.y)
}

fun f() {
    X(1, 2) + X(1, 3) // X(2,5)
}








data class Point(val x: Int, val y: Int) : Comparable<Point> {
    operator fun plus(other: Point) = Point(x + other.x, y + other.y)
    operator fun minus(other: Point) = Point(x - other.x, y - other.y)
    operator fun times(other: Point) = Point(x * other.x, y * other.y)
    operator fun div(other: Point) = Point(x / other.x, y / other.y)
    operator fun rem(other: Point) = Point(x % other.x, y % other.y)
    operator fun not() = Point(0, 0)
    operator fun inc() = Point(x + 1, y + 1)
    operator fun dec() = Point(x - 1, y - 1)

    override fun equals(other: Any?): Boolean {  // implemented by Any?
        val p = other as? Point ?: return false
        return p.y == y || p.x == x // custom equality
    }

    override operator fun compareTo(other: Point): Int { // implemented in comparable
        return with(other) {
            sqrt((x * x + y * y).toDouble()).toInt()
        } - sqrt((x * x + y * y).toDouble()).toInt()
    }
}

fun example() {
    var point = Point(1, 1) + Point(1, 1) // == Point(2,2)
    Point(1, 1) * Point(2, 2) // == Point(2,2)
    Point(2, 2) / Point(2, 2) // == Point(1,1)
    Point(2, 2) % Point(2, 2) // == Point(0,0)
    Point(2, 2) - Point(2, 2) // == Point(0,0)

    point += Point(
        1,
        1
    ) // works by default, can be explicitly overridden by calling plusAssign.  Dont implement both since its confusing


    // all operators can be called as regular functions from java
    var p = Point(2, 2)
    p++ //Point(3, 3)
    --p //Point(2, 2)
    !p //Point(0, 0)

    println(
        Point(2, 2) == Point(2, 1) //todo: step into ==
    ) // prints true

    println(
        Point(2, 2) >= Point(2, 1) //todo: step into >=
    ) // prints true

}