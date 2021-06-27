package basics.p1_basics.v_5_smart_casts

interface Expr // marker interface
class Num(val value: Int): Expr
class Sum(val left: Expr, val right: Expr): Expr

fun eval(e: Expr): Int {
    if (e is Num){
        return e.value // smart cast
    }
    if (e is Sum){
        return eval(e.left) + eval(e.right)
    }

    throw IllegalArgumentException("duck")
}


fun main() {
    println(
        eval(Sum(Sum(Num(1),Num(1)),Num(1)))
    )

    val s = Sum(Num(1),Num(2)) as Num // explicit cast -  idea cast warning
    println(s.value)

}

//smart casts can only be used with a class property that is a val and that doesn’t have a custom accessor
//This requirement means the property has to be final