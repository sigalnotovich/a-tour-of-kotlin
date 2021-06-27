package basics.p3_classes_objects_interfaces
interface Clickable {
    fun click()
    fun showOff() = println("I'm focusable!")
}
// like java, kotlin interfaces can have
// cant contain state

class Button : Clickable {
    override fun click() = println("I was clicked")
    // todo: try deleting the override key word
    // todo: try override showOff
}
// : is shorter then extends
// a class can implement many interfaces and extend only one other class



interface Focusable {
    fun setFocus(b: Boolean) =
        println("I ${if (b) "got" else "lost"} focus.")

    fun showOff() = println("I'm focusable!")
}

//todo: delete  implementation and use IDEA to generate  stubs
class FocusableButton(): Focusable, Clickable {
    override fun click() {
        println("C L I C K !")
    }

    override fun showOff() { //todo: try deleting this method, what does the compiler say ?
        super<Focusable>.showOff() // calling a specific parent impl
        super<Clickable>.showOff()
    }

}


// if using a kotlin interface from java, you must implement all methods,
// even those that have a kotlin impl




