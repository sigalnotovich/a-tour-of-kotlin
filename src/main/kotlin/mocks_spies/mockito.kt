package mocks_spies

data class OrderModel(
    var status: String,
    val itemId: String,
    val id: Int
)

var ordersList = mutableListOf<OrderModel>()

@AllOpen
 class DbClient {

     fun insert(name: String, sureName: String, id: Int) {
        println("inserting $name  $sureName")
        ordersList.add(
            OrderModel(name, sureName, id)
        )
    }

     fun read(id: Int) = ordersList.find { it.id == id }

     fun find(name: String, sureName: String) = ordersList.find {
        it.status == name && it.itemId == sureName
    } != null

}

@AllOpen
 class OrderRepository(private val client: DbClient) {
     fun getById(id: Int): OrderModel {
        return client.read(id) ?: throw NoSuchElementException()
    }

     fun update(order: OrderModel) {
        ordersList = ordersList.map {
            if (it.id == order.id) order else it
        }.toMutableList()
    }

     fun insert(order: OrderModel) {
        if (client.find(order.status,order.itemId)) {
            throw RuntimeException("duplicate entity")
        }
        client.insert(order.status, order.itemId, order.id)
    }
}

@AllOpen
 class ShippingClient {
     fun send(order :OrderModel){
        println("sending order ${order.status}")
        // call some restful api
    }
}

@AllOpen
 class Service(
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

@AllOpen
 class OrderValidator {
     operator fun invoke(order: OrderModel) {
        if (order.status.isEmpty()) {
            throw RuntimeException("invalid order")
        }
    }
}



annotation class AllOpen