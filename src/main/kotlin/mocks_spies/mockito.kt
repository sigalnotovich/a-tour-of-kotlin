package mocks_spies

data class OrderModel(
    var status: String,
    val itemId: String,
    val id: Int
)

var ordersList = mutableListOf<OrderModel>()

open class DbClient {

    open fun insert(name: String, sureName: String, id: Int) {
        println("inserting $name  $sureName")
        ordersList.add(
            OrderModel(name, sureName, id)
        )
    }

    open fun read(id: Int) = ordersList.find { it.id == id }

    open fun find(name: String, sureName: String) = ordersList.find {
        it.status == name && it.itemId == sureName
    } != null

}

open class OrderRepository(private val client: DbClient) {
    open fun getById(id: Int): OrderModel {
        return client.read(id) ?: throw NoSuchElementException()
    }

    open fun update(order: OrderModel) {
        ordersList = ordersList.map {
            if (it.id == order.id) order else it
        }.toMutableList()
    }

    open fun insert(order: OrderModel) {
        if (client.find(order.status,order.itemId)) {
            throw RuntimeException("duplicate entity")
        }
        client.insert(order.status, order.itemId, order.id)
    }
}

open class ShippingClient {
    open fun send(order :OrderModel){
        println("sending order ${order.status}")
        // call some restful api
    }
}

open class Service(
    private val repository: OrderRepository,
    private val validateOrder: OrderValidator,
    private val shippingClient: ShippingClient) {

        fun shipOrder(id: Int): OrderModel {
            return repository.getById(id).apply {
                validateOrder(this)
                shippingClient.send(this)
                status = "sent"
                repository.update(this)
            }
        }
}

open class OrderValidator {
    open operator fun invoke(order: OrderModel) {
        if (order.status.isEmpty()) {
            throw RuntimeException("invalid order")
        }
    }
}
