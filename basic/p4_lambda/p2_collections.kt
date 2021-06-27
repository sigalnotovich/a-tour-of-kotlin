package basics.p4_lambda

val peopleList = listOf(Person("Alice", 29), Person("Bob", 31))
val max = peopleList.filter { it.age > 30 }

val ls1 = listOf(1, 2, 3, 4)
val mapped = ls1.map { it * it }

val _names = peopleList.map { it.name }

val combined = peopleList.filter { it.age > 30 }.map { it.name }



val maxAge = peopleList.filter { it.age == peopleList.maxByOrNull(Person::age)?.age }
//todo what happens if the list is empty ?


val numbers = mapOf(0 to "zero", 1 to "one")
val mapMapped = numbers.mapValues { it.value.toUpperCase() }
// filterKeys
// filterValues
// ...


val isAllAdults = peopleList.all { it.age > 18 }
val containsAdult = peopleList.any { it.age > 18 }
val contAdults = peopleList.count { it.age > 18 }
val findFirstAdult = peopleList.find { it.age > 18 }
val findLastAdult = peopleList.findLast { it.age > 18 }
val convertToMap = peopleList.groupBy { it.age }
//{29=[Person(name=Dani, age=29)],
// 31=[Person(name=Katya, age=31), Person(name=Dana, age=31)]}

// flatting

val strings = listOf("aabc", "def")
val flattened = strings.flatMap { it.toList() }
//[a, a,b, c, d, e, f]
val uniq = strings.toSet()

// collections are fun, explore em !!!
