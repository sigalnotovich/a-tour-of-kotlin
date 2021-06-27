package basics.p3_classes_objects_interfaces

interface Developer {
    val nickname: String // abstract property
}

class Igor(override val nickname: String): Developer
class Boris: Developer {
    override val nickname = "boss"
}
class Sergei(private val id: String): Developer {
    override val nickname: String
        get() = "iddqd $id"
}

interface MegaDeveloper {
    val email: String // must be overridden
    val nickname: String // can be inherited
        get() = "nick->$email"
}

class Vladimir(val surname: String = "putin"){
    var address = "no one knows"
    set(value) { // the compiler knows value is a string
        println("puting is moving to $value")
        field = address // field is a reserved word pointing to the backing field of our prop
    }
}


class Counter {
    var counter: Int = 0
        private set // can be set only in this class

    fun inc() {
        counter+=1
    }
}

// more prop types we will cover later
// - lazy properties
// - lateinit properties
// - const properties