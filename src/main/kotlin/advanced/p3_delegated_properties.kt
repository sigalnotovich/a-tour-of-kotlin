package advanced

import kotlin.reflect.KProperty


class Foo {
    val p: String by lazy {
        // some expensive IO or computation...
        "im a lazy value"
    }
}



//                          a delegate
class ObservableProperty(
    var propValue: Int
) {

    operator fun getValue(p: Person, prop: KProperty<*>): Int {
        // get from db ...
        return propValue
    }

    operator fun setValue(p: Person, prop: KProperty<*>, newValue: Int) {
        // save in db ...
        propValue = newValue
    }
}


class Person(
    val name: String, age: Int, salary: Int
) {
    private val _dynamicProps = mutableMapOf<String,String>()
    // every access to Int will be delegated to ObservableProperty delegate
    var age: Int by ObservableProperty(age)
    var salary: Int by ObservableProperty(salary)

    var nickName by _dynamicProps //
    var bestFriend by _dynamicProps

}

fun example4() {
    val sergei = Person("sergei", 34, 5000)
    sergei.age = 4 // calls setValue of ObservableProperty

    sergei.nickName = "seri"
    /*
     - does _dynamicProps["nickName"] = "seri"
     - this works because mutableMap has getValue,setValue methods
     - and "nickName" is extracted form the second argument of setValue ( KProperty<*> )
    */
}




