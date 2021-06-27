package basics.p3_classes_objects_interfaces

import java.io.File


// - object declaration is a way to define a singleton.
// - companion objects  - like java static class
// - object expression is used instead of Java’s anonymous class. ( make things on the fly )


object Payroll {
    val devs = arrayListOf<Developer>()

    fun calculateSalary() {
        for (dev in devs) {
            dev.nickname
            // do something ..
        }
    }
}
// an object can contain everything a class has besides constructors


// can also inherit
object CaseInsensitiveFileComparator : Comparator<File> {
    //todo: find usages of this object
    override fun compare(file1: File, file2: File): Int {
        return file1.path.compareTo(file2.path, ignoreCase = true)
    }
}
// useful when you dont have state, and some framework forces you to inherit

// be ware of singletons

val files = listOf(File("/Z"), File("/a"))
val sorted = files.sortedWith(CaseInsensitiveFileComparator)
// ["/a", "/z"]


data class Person(val static: String) { // static is not a reserved word in kotlin
    // all people instances will share the same NameComparator Object
    object NameComparator : Comparator<Person> { // like a static object.
        override fun compare(p1: Person, p2: Person): Int =
            p1.static.compareTo(p2.static)
    }
}


val persons = listOf(Person("dima"), Person("igor"))
val sortedPeople = persons.sortedWith(Person.NameComparator)


//  COMPANION OBJECTS
//companion objects can do anything objects can
// inherit
// implement interfaces
class Boy {

    private constructor(dontcare: String) {
        println("only my companion cal call me")
    }

    companion object {
        fun bar() {
            println("Companion object called")
        }

        fun newBoy(): Boy { //todo: find usages
            return Boy("da") // can call private constructor
        }
    }

    fun canCallBar() {
        bar() // the companion key word allows that
    }
// todo: navigate to test using IDEA
}



fun Boy.Companion.SayHello() {
    println("companion objects can be extended !")
    // when should you use this ?
    // for example if Boy is part of the business logic
    // and you add an extension function to serialize it from a json, or an xml
    // this will decouple the class from a format that represents it
}


// creating classes on the fly ( java anonymous inner  classes )


val fileList = listOf(File("/Z"), File("/a"))
val s = fileList.sortedWith(object : Comparator<File> { // todo: use idea to convert to lambda
    override fun compare(o1: File?, o2: File?): Int {
        return 0
    }
})

// lambdas are SAM interfaces
// creating objects on the fly is useful in case the interface we implement has more than one method
// on the fly objects can implement any number of interfaces or no interface