fun main() {

    data class Person(val name: String, val age: Int? = null)

    val boris = Person("Boris")
    val igor = Person("Igor", 24)
    val people = listOf(boris, igor)
    val oldest = people.maxByOrNull { it.age ?: 0 }
    println(
        """
                    Oldest JavaPerson is         $oldest
                  
                            (╯°□°）╯︵ uılʇoʞ
                            
                """.trimIndent()
    )
}





