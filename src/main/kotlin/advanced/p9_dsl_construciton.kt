package advanced

//                              or type safe builders

//                              from api to DSL.

class Human {
    lateinit var name: String
    lateinit var age: Number
    lateinit var address: Address

}

class Address {
    lateinit var street: String
    lateinit var number: Number
    lateinit var city: String
}

fun human(block: Human.() -> Unit)= Human().apply {
    block(this)
}

fun Human.address(block: Address.() -> Unit)  {
    address = Address().apply(block)
}

val person = human {
    name = "John"
    age = 25
    address {
        city = "Petah Tikva"
        number = 2
        street = "kaplan"
    }
}
