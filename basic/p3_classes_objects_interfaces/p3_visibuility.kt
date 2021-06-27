package basics.p3_classes_objects_interfaces

// in kotlin its public by default
// unlike java, kotlin dont uses package private visibility ( protected in java )
// as an alternative kotlin has an internal modifier , visible in a module ( gradle project )

// modifiers:
// -  public ( default )
// - internal ( module private )
// - protected ( only subclasses )
// - private ( class only )


interface State : java.io.Serializable

interface View {
    fun getCurrentState(): State
    fun restoreState(state: State) {}
}


class ViewButton : View {
    override fun getCurrentState(): State {
        return ButtonState()
    }

    override fun restoreState(state: State) { /*...*/
    }

    class ButtonState : State { // like a static nested class
// inner classes cant access parent class
    }

    inner class OtherState : State {
        // inner keyword to explicitly allow access to outer class
        fun getOuterReference(): ViewButton = this@ViewButton // special syntax
    }
}


interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun eval(e: Expr): Int =
    when (e) {
        is Num -> e.value // smart cast
        is Sum -> eval(e.left) + eval(e.right)
        else -> throw IllegalArgumentException("duck")
// must provide an else since we dont know hwo will implement Expr interface
    }

sealed class Expression {
    class Num(val value: Int) : Expression()
    class Sum(val left: Expression, val right: Expression) : Expression()
}

fun eval(e: Expression): Int =
    when (e) {
        is Expression.Num -> e.value // smart cast
        is Expression.Sum -> eval(e.left) + eval(e.right)
    }
// else not needed



