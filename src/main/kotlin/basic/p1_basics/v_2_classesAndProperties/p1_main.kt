package basics.p1_basics.v_2_classesAndProperties

import basic.JavaPerson


// value object
// public is the default visibility
data class Person(val name: String)

data class FamilyPerson(
    val name: String, // this property will result in a backing field, getter and constructor arg
    var isMarried: Boolean // this one will also have a setter
)


fun main() {
    // no new keyword
    //todo: 1 remove the data keyword and re-run
    val person = FamilyPerson("Vladimir", false)
    println(person)

    // using java code, easy !
    val javaPerson = JavaPerson("da")
    println(javaPerson.name) // calls getName

    //todo: 2 add isMarried field with a setter to JavaPerson, and set it from kotlin
}

