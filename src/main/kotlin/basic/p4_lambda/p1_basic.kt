package basics.p4_lambda

// you will use lambdas all the time! LIKE ALL THE TIME !!!


data class Person(val name: String, val age: Int)

// no lambda example
fun oldest(people: List<Person>): Person? {
    var oldest: Person? = null
    for (person in people) {
        if (person.age > oldest?.age ?: 0) {
            oldest = person
        }
    }
    return oldest
}

fun withLambda(people: List<Person>){
    people.maxByOrNull({ it.age })
    people.maxByOrNull { it.age }
    people.maxByOrNull(Person::age) // a property getter is a function...
}

val lambda = { x: Int, y: Int -> x + y }
//param list
// body
// in curly bracets {}
// todo: use idea to check type ( ctrl+j ) - on mac

fun ex1(){
    { println(42) }() //IIFE  - Immediately-invoked Function Expressions
    // 42
}


val people = listOf(Person("Alice", 29), Person("Bob", 31))

val names = people.joinToString(separator = " ", transform = { p: Person -> p.name })
val clearNames = people.joinToString(" ") { p: Person -> p.name } // easy to read
val clearNames3 = people.joinToString(" ") { p -> p.name } // better ?
val clearNames2 = people.joinToString(" ") { it.name } //  better ?
                    // meet it, its taken from groovy, you will use it a lot.



fun printNames(lst: List<Person>){
    var prefix = 0
    lst.forEach {
        prefix = it.age
        println("$prefix: ${it.name}")
    // can access any variable in scope
    // can mutate variables in scope
    }
    // unlike java that can only access final
}

fun autoBoxing(){
    var counter = 0
    val inc = { counter++ }
    // the compiler boxes the primitive, counter
    // this was not possible in java until  ~ java 9

}
