package basics.p3_classes_objects_interfaces

// The so-called fragile base class problem
// changing base class code can result in broken sub classes
// Effective Java by Joshua Bloch - “design and document for inheritance or else prohibit it.”
// This means all classes and methods that aren’t specifically intended to be overridden
// ought to be explicitly marked as final.

//final by default
open class RichButton: Clickable {
    final override fun click() = print("") // final here means that subclasses wont be able to override this
    open fun animate() {}
    fun disable() {}
}
//smart casts can only be used with a class property that is a val and that doesn’t have a custom accessor

abstract class Animal{
    abstract fun roar() //todo: try deleting the abstract
    open fun bite() = println("biting")
    fun jump() = println("jumping") // final by default
}