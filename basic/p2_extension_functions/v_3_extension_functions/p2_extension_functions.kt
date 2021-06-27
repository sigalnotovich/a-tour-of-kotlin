package basics.p2_extension_functions.v_3_extension_functions

//Adding methods to other people’s classes

//extension function is a function that can be called as a member of a class but is defined outside of it

fun String.lastChar(): Char = this.get(this.length - 1)
//todo: find usages using idea

// receiver type
// receiver object
// you dont really need the this keyword
// extension functions don’t have access to private or protected members of the class
// extension functions are indistinguishable from members
//( you can call members and other extension funcs from extension funcs )
// can be exported from your package

fun run() {
    println(
        "Kotlin".lastChar()
    )
}

//Even though String isn’t part of your code,
// you may not even have the source code to that class
// you can extend it !!!
