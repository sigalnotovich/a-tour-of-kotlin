package basics.p3_classes_objects_interfaces

//  fragility caused by implementation inheritance
// base class changes and you die


//Decorator pattern - sometimes we need to wrap things


class DelegatingCollection<T> : Collection<T> {
    private val innerList = arrayListOf<T>()

    override val size: Int get() = innerList.size
    override fun isEmpty(): Boolean = innerList.isEmpty()
    override fun contains(element: T): Boolean = innerList.contains(element)
    override fun iterator(): Iterator<T> = innerList.iterator()
    override fun containsAll(elements: Collection<T>): Boolean =
        innerList.containsAll(elements)
}


//vs

class DelegatingCollection2<T>(
    innerList: Collection<T> = ArrayList()
) : Collection<T> by innerList { // meet 'by' keyword
    // whats the difference between extension functions and this technique ?
    fun somethingNew() = "opa"

    override val size: Int get() = -1 // can also override delegated methods
}