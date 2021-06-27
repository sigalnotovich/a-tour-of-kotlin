package advanced

/*
                                        variance

                                generics and sub typing


*/

val lst : List<Any> = listOf() // covariant
val lst2 : MutableList<String> = mutableListOf() // invariant

/*
        is it safe to pass a variable of type List<String> to a function expecting List<Any> ?
                    -  safe
        what about passing MutableList<String> to a func expecting MutableList<Any> ?
                    - not safe
*/
fun f1(list: MutableList<Any>)  {
    list.add(42)
}

fun f2(list: List<Any>){
    println(
        list.first()
    )
}

fun example5(){
//    f1(mutableListOf<String>("")) //- not safe
    f2(listOf("")) // no problem
}
/*
                                        Types vs Classes

                                        are they the same ?

                                        NO !!
                                        List is a class
                                        List<Map<Stirng,String>> is a type
                                        a generic class can have an infinite number of subtypes

             - Storing a value in a variable is allowed only when the value type is a subtype of the variable type
             - Passing an expression to a function is allowed only when the type of the expression
                        is a subtype of the function parameter type



             - INVARIANT: MutableList is called invariant if, for any two different types A and B,
               MutableList<A> isn’t a subtype or a supertype of MutableList<B>

             - COVARIANT:  If A is a subtype of B, then Box<A> is a subtype of Box<B>.

             - CONTRA VARIANT:  If A is a subtype of B, then Box<A> is a subtype of Box<a>.

               Java syntax is: List<? extends A> ... List<? super A>

               examples:

*/

//                              covariance
open class Animal{
    fun feed() {}
}

class Herd<T: Animal> {
    val size : Int get() = TODO()
    operator fun get(i: Int): T = TODO()
}

fun feed(herd: Herd<Animal>) {
    for (i in 0 until herd.size)
        herd[i].feed()
}

class Cat: Animal(){
    fun pet() {}
}

fun treatCats(cats: Herd<Cat>) {
    for (i in 0 until cats.size){
        cats[i].pet()
    } //todo - code smell, mixing levels of abstraction
//    feed(cats) // - compiler is angry
    // todo: make Herd covariant and feed cats
}


interface Producer<out T> {
    fun produce(): T // out position --- a producer is covariant
    // List<T> is a producer
}

//                              contravariance

interface Comerator<in T>{
    fun compare(x: T, y: T): Int
}

val anyComp = object :Comparator<Any> { //todo: use idea to convert to a lambda ( SAM interfaces )
    override fun compare(x: Any, y: Any): Int = x.hashCode() - y.hashCode()
}

val list = listOf("da", "1232", "asdf3", "4ddd", "588987")
val sortedList  = list.sortedWith(anyComp) //todo: use idea to view sortedWith arg type
/*
                    sortedWith function expects a Comparator<String>
                    but its safe to pass one that can compare more general types, like Comparator<Any>
                    This means Comparator<Any> is a subtype of Comparator<String> !!!  - "contra" variance
*/



