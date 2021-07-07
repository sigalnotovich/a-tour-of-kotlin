fun main() {
    data class Person(val name: String, val age: Int? = null)
    val people = listOf(Person("Boris"), Person("Igor", 24))
    val oldest = people.maxByOrNull { it.age ?: 0 }
    println(
        """
                    Oldest JavaPerson is         $oldest
                  
                            (╯°□°）╯︵ uılʇoʞ
                            
                """.trimIndent()
    )

}


