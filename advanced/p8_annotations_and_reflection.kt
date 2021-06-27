package advanced

import kotlin.reflect.jvm.javaField
import kotlin.reflect.memberProperties

@Deprecated("Use removeAt(index) instead.", ReplaceWith("removeAt(index)"))
fun remove(index: Int) {
}
/*
Annotations can have parameters of the following types only:
 - primitive types
 - strings
 - enums
 -  class references
 - other annotation classes
*/


val da = remove(2)// todo: use idea to auto replace deprecated method


/*
            controlling java api
    @JvmName changes the name of a Java method or field generated from a Kotlin declaration.
            ^^ the above can be useful with json serialization libs like Jakson, Gson

    @JvmStatic can be applied to methods of an object declaration or a companion object to expose them as static Java methods.
        ^^ useful with junit setup class
*/

annotation class JsonName(val name: String)
annotation class JsonExclude

data class Persona(
    @field:JsonName("alias") val firstName: String,
    @field:JsonExclude val age: Int? = null
)


//          YOU WILL PROBABLY NEVER USE REFLECTION IN "REAL LIFE" UNLESS YOU ARE A FRAMEWORK /  LIB AUTHOR
// todo: use idea to find usages "serializeObject"
fun serializeObject(obj: Any): String {
    return buildString {
        append("{")
        obj.javaClass.kotlin.memberProperties
            .filter {
                it.javaField?.annotations?.find { annotation ->
                    annotation is JsonExclude
                } == null
            }.forEach { prop ->
                prop.javaField?.annotations?.find { it is JsonName }?.let {
                    append((it as JsonName).name)
                } ?: append(""""${prop.name}"""")
                append(": ")
                append("${prop.get(obj)}")
            }
        append("}")
    }
}