package functional

import java.lang.Math.random

data class Product(
    val id: Int = random().toInt(),
    val product_type: String,
    val attributes: List<String>,
    val color: String = "Black",
)

val products = listOf(
    Product(product_type = "Accessory", attributes = listOf("Fabric","Material")),
    Product(product_type = "Accessory", attributes = listOf("Fabric")),
    Product(product_type = "Accessory", attributes = listOf("Material")),
    Product(product_type = "Clothes", attributes = listOf("Fabric","Material","Model is wearing")),
    Product(product_type = "Clothes", attributes = listOf("Model measurements")),
    Product(product_type = "Clothes", attributes = listOf("Item Care")),
    Product(product_type = "Clothes", attributes = listOf("Item Care", "Fabric")),
    Product(product_type = "Bags", attributes = listOf("Fabric", "Measurements")),
    Product(product_type = "Bags", attributes = listOf("Fabric")),
    Product(product_type = "Bags", attributes = listOf("BackPack","Fabric")),
    Product(product_type = "Bags", attributes = listOf("Material","BackPack")),
    Product(product_type = "Bags", attributes = listOf("Purse","Army")),
    Product(product_type = "Shoes", attributes = listOf("Fabric","Material")),
    Product(product_type = "Shoes", attributes = listOf("Heels","Walking")),
    Product(product_type = "Shoes", attributes = listOf("jogging")),
    Product(product_type = "Shoes", attributes = listOf("fishing","heels")),
    Product(product_type = "Shoes", attributes = listOf("man")),
    Product(product_type = "Shoes", attributes = listOf("children")),
    Product(product_type = "Living", attributes = listOf("Fabric")),
    Product(product_type = "Living", attributes = listOf("Measurements")),
    Product(product_type = "Living", attributes = listOf("Fabric","Material")),
)

fun `find category with most attribures`(){
    TODO()
}

fun `count avg number of attributes per category`(){
    TODO()
}

fun `unique attributes per category`(): Map<String, List<String>> {
    TODO()
}

fun `unique category per attribute`(){
    TODO()
}

fun `unique global attributes`(){
    //fold
    TODO()
}

