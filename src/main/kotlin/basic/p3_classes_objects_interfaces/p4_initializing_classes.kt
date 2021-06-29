package basics.p3_classes_objects_interfaces

open class User constructor(nickname: String = "bob") {
    // primary constructor, default values are supported
    val nick : String // todo: use idea to join declaration and assignment
    init {
        nick = nickname
    }
}

class ZimUser(nickname: String) : User(nickname)  // primary constructor must initialize super class

class NOP // default constructor without arguments

//what example of private constructors in java you can think of ?
class Secret private constructor() {
    fun something() = println(
        "no one outside this class can call my constructor. companion objects coming soon"
    )
}
// to implement a singleton, kotlin provides object declaration


open class Human {
    var name: String
    lateinit var  age: List<Int> // meet lateinit, why it's necessary here ?
    constructor(name: String){
        this.name = name
    }
    constructor(name: String, age: List<Int>){
        this.name = name
        this.age = age
    }
}
// because not all constructors initialize it


class SuperHuman : Human {

    constructor(
        name: String,
        age: List<Int> = listOf(Int.MAX_VALUE)
    ) : super(name, age) { // calling parent
        println("im a super human")
    }

    constructor(name: String) : this(name, listOf()) // calls the above constructor
    // todo:delete the above, use idea to generate secondary constructor stub ( ctrl + n )
}

