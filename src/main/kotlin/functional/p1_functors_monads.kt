package functional


internal interface Functor<T> {
    fun <R> map(f: (T) -> R): Functor<R>
}


//                                  example 1
class Identity<T>(
    private val value: T
) : Functor<T> {
    override fun <R> map(f: (T) -> R) = Identity(f(value))
}

val str = Identity("abc")
val len = str.map { x -> x.length }


data class Person(val name: String, val sureName: String)

fun composed() = Identity(Person("vladimir","putin"))
    .map(Person::name)
    .map { it.substringBefore("imir") }
    .map { it.toUpperCase() }
    .map { it.toList() }


//                                  example 2
class FOptional<T> private constructor(valueOrNull: T?) : Functor<T> {
    private val valueOrNull = valueOrNull

    companion object {
        fun <T> of(a: T): FOptional<T> = FOptional(a)
        fun <T> empty(): FOptional<T> = FOptional(null)
    }

    override fun <R> map(f: (T) -> R): FOptional<R> =
        if (valueOrNull == null) empty() else of(f.invoke(valueOrNull))

}

fun mapEmpty() = FOptional.empty<String>().map { it.length }



//                                  example 3
class FList<T>(value: Iterable<T>) : Functor<T> {
    private var list: List<T> = value.toList()

    override fun <R> map(f: (T) -> R): FList<R> {
        val result = mutableListOf<R>()
        for (t in list)
            result.add(f(t))
        return FList(result)
    }

}

fun flist() = FList(listOf<Int>()).map { it.toString() }


//                              MONADS

fun tryParse(s: String): FOptional<Int> = try {
    val i = s.toInt()
    FOptional.of(i)
} catch (e: NumberFormatException) {
    FOptional.empty()
}

//          mmm...
val parsed: FOptional<FOptional<Int>> = FOptional.of("123").map {
    tryParse("123")
}

//      lets turn FOptional into a monad
internal interface Monad<T> : Functor<T> {
    fun <M> flatMap(f: (T) -> M): M
}

class MOptional<T> private constructor(valueOrNull: T?) : Functor<T>, Monad<T> {
    private val valueOrNull = valueOrNull

    companion object {
        fun <T> of(a: T) = MOptional(a)
        fun <T> empty(): MOptional<T> = MOptional(null)
    }

    override fun <R> map(f: (T) -> R): MOptional<R> =
        if (valueOrNull == null) empty() else of(f(valueOrNull))

    override fun <M> flatMap(f: (T) -> M): M {
        return valueOrNull?.let(f)!!
        // BUGGY IMPLEMENTATION
    }


}


fun flattened() = MOptional.of("123").flatMap {
    tryParse(it)
}



/* other monads you know:
        - List
        - Sequence
        - Promise
        - Future
        - Stream
        - Optional
 */
