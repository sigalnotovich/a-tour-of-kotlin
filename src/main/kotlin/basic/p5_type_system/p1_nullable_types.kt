package basics.p5_type_system

// because NullPointerException sucks
fun strLen(s: String) = s.length
fun strLen1(s: String?) = s?.length //todo: try deleting the question mark from the function body


/*
String? ==> String or null
todo: why this is better then java Optional ?

 - Optional can contain null
 - java sdk dont consistently use Optional across the echo sys
 - performance, a wrapper objects

 */

//          elvis operator

fun strLen2(s: String?) = s?.length ?: -1
fun strLen3(s: String?) = s?.length ?: throw RuntimeException("duck")


//          safe cast
class Person(val name:String){
    override fun equals(other: Any?): Boolean {

        val person = other as? Person ?: return false

        return name == person.name
    }
}


//          not-null assertion

fun strLen4(s: String?) = s!!.length // I know better !!

// be careful using this.

fun theLetFunction() {
    fun sendEmailTo(s:String) = s
    val email: String? = null
//    sendEmailTo(email) this fails to compile



    email?.let { // much better then an if statement
        sendEmailTo(it)
    }
}

object LateInit // todo: navigate to test using idea



//          Extending nullable Types


fun String?.isNullOrEmpty():Boolean {
    return this != null && this != "" // the second this is smart casted to String ( not null )
}


//          nullable type params

fun  <T> printHashCode(t: T) = println(t?.hashCode()) // Any? upper  bound
fun  <T: Any> printHashCode1(t: T) = println(t.hashCode()) // set Any upper bound. ( now no need for null safety operator .? )





/*          nullability and java - platform types

            the compiler cant know if a java method can return null
            @NotNull annotation is not enforced
            This is why we always treat java types as nullable

            example:
*/


fun platformNull(){

    JavaClass.retNull().length // will throw NullPointerException
    JavaClass.retNull()?.length // compiler dont say using ?. is redundant

    JavaClass.retAString().length // no exception
    JavaClass.retAString()?.length // compiler dont say using ?. is redundant
}





/*          Primitive types

        kotlin has no distinction between primitives and objects
        like java int vs Integer for example
        you always use kotlin Int
        at runtime the compiler will attempt to compile it into int as much as possible
 */



/*          Any, Any?, Unit, Nothing

            open TypeHierarchy.jpg


 */

val x = Unit // <-- where is Unit located ?

fun nothing(): Nothing { // nothing never returns
    throw java.lang.RuntimeException()
}


//              nullability and collections

val l1 :List<Int?> = listOf()
val l2 :List<Int>? = null


val l3 = mutableListOf(1,2,3)
val l4: List<Int> = l3
// is l4 mutable or not ?
// open collectionsAndJava.png



//          java and kotlin collections

fun callJava(){

    Printer.print(mutableListOf(1,2,3))

    Printer.add1(listOf(1,2,3)) // even though we pass an immutable list, java code can change it. ( since java has no distinction between a mutable and an immutable list )

    Printer.printArray(listOf(1,2,3).toTypedArray()) // converting a list to a java Array
    Printer.printArray(arrayOf(1,2,3)) // kotlin arrays are automatically converted to java arrays by the compiler
}