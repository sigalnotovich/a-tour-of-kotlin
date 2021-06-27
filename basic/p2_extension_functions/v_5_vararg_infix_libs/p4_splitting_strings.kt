package basics.p2_extension_functions.v_5_vararg_infix_libs

fun run() {
    println(
        "12.345-6.A".split("\\.|-".toRegex())
    )
    //[12, 345, 6, A]

    println(
        "12.345-6.A".split("-",".")
    ) // same thing
}


fun run1(){
    val path = "/users/putin/kotlin_kicks_ass/picture.jpeg"
    val dir = path.substringBeforeLast("/")
    val fileName = path.substringAfterLast("/")

    val (name, extension) = fileName.split(".")

    println("Dir: $dir, name: $name, ext: $extension")
    //Dir: /users/putin/kotlin_kicks_ass, name: picture, ext: jpeg
}



fun usingRegex(path: String) {
    //triple-quoted string. In such a string, you don’t need to escape any characters
    val regex = """(.+)/(.+)\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)
    if (matchResult != null) {
        val (directory, filename, extension) = matchResult.destructured
        println("Dir: $directory, name: $filename, ext: $extension")
        //Dir: /users/putin/kotlin_kicks_ass, name: picture, ext: jpeg
    }
}


fun multiLineStr() {
    val kotlinLogo = """| //
                   .|//
                   .|/ \"""
    println(
        kotlinLogo.trimMargin(
            "."
        )
    )
}




