package functional

import org.junit.Test





class P2_exerciseKtTest {


    @Test
    fun uniqueTags() {
        //products.map { it.product_type to it.attributes }.groupBy { it.first }.flatMap { x -> x.value.map { x.key to it.second } }.toMap()
        `unique attributes per category`()
        `find category with most attribures`()
        `count avg number of attributes per category`()
        `unique category per attribute`()
    }
}