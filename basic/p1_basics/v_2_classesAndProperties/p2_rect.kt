package basics.p1_basics.v_2_classesAndProperties

import java.sql.Connection
import java.sql.DriverManager



//todo: find usages
class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() { //todo: 3 use idea to convert expression body
            return height == width
        }
}

class Repository(connectionString: String){ // constructor field
    // never do this, use dependency injection
    val connection: Connection = DriverManager.getConnection(connectionString)
}