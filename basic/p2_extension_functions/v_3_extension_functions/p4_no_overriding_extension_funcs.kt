package basics.p2_extension_functions.v_3_extension_functions.p4_no_overriding_extension_funcs

open class View {
    open fun click() = println("click click")
}

class Button: View() {
    override fun click() = println("only one click")
}

fun run() {
    val view: View = Button()
    view.click() // what method will be called ?

    view.check() // what method will be called ?
    (view as Button).check("walla")
    (view as Button).check() // what method will be called ?
}

fun View.check() = println("im a view")
fun Button.check() = println("im a button")
fun Button.check(s: String) = println("im a $s")