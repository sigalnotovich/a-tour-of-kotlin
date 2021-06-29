package etl

import java.sql.DriverManager
import java.sql.SQLException


/*
                    ETL EXERCISE


PART 1:
            GIVEN THE API ( description in examples.http )
            - Fetch all products
            for every product in the list:
                - update the product. set 'tags' to contain the ids of all other products within the same category.
                - set the avgPrice attribute with the avg price of all products in the category
                - load products to a mysql db
                    - start by creating the schema
                    - then load products to mysql

            use functional programing style
            write unit tests
            use mockk to mock the access to mysql when writing
            try to TDD
            use dependency injection



PART 2:
            IMPLEMENT A SPRING CRUD API OVER THE PRODUCTS STORED IN MYSQL

            - provide a filter api that will allow fetching all products within a specific category, specific material4
            - provide an api to get a product by id,name,
            - provide an api to delete a product
            - provide an api to update a product

            WHEN DESIGNING THE API, consider restfull api best practices.
            use query/path params when necessary

*/



fun main() {
    val host = System.getenv("DB_HOST")
    val user = System.getenv("DB_USER")
    val pass = System.getenv("DB_PASS")
    val db = System.getenv("DB_NAME")
    val connectionUrl = "jdbc:mysql://$host:3306/$db"

    try {
        DriverManager.getConnection(connectionUrl, user,pass).use { conn -> // use closes the connection
            conn.prepareStatement("SELECT * FROM user").use { ps ->
                ps.executeQuery().use { rs ->
                    while (rs.next()) {
                        val login = rs.getString("login")
                        println(login)
                    }
                }
            }
        }
    } catch (e: SQLException) {
        e.printStackTrace()
    }
}