package personio

import java.util.concurrent.LinkedBlockingDeque

data class Product(val id: Int, var quantity: Int)

data class Order(val orderId: Int, val products: Map<Int, Int>)

class OrderProcessor(private val products: Array<Product>) {

    private val orders = LinkedBlockingDeque<Order>()

    fun addOrder(orderId: Int, orderItems: Map<Int, Int>) {
        // Add the order with the given orderId and orderItems which has the key
        // as product_id, and value as order quantity
        orders.add(Order(orderId, orderItems))
    }

//    suspend fun processOrderOptimized() {
//      val coroutineScope = CoroutineScope { Dispatcher.default + exceptionsHandler + SupervisorJob() }
//          coroutineScope.launch(processOrder())
//    }

    fun processOrder(): Pair<Int, Boolean> {
        // Process the next order and return a Pair containing the orderId and a
        // Boolean indicating whether the order was processed successfully
        val nextOrder = orders.poll()
        val orId = nextOrder.orderId
        val items = nextOrder.products
        items.forEach { i ->

            val existingProduct = getProductByIdOrThrow(i.key)
            if (existingProduct.quantity < i.value) {
                return Pair(orId, false)
            } else {
                updateInventory(existingProduct.id, existingProduct.quantity - i.value)
            }
        }

        return Pair(orId, true)
    }

    //    @Transactional
    @Synchronized
    fun updateInventory(productId: Int, quantity: Int) {
        // Update the inventory count for the item with the given productId by
        // the specified quantity
        val existingProduct = getProductByIdOrThrow(productId)
        existingProduct.quantity = existingProduct.quantity + quantity
    }

    fun getMyOrders(orderId: Int): Order? {
        return this.orders.find { it.orderId == orderId }
    }

    private fun getProductByIdOrThrow(productId: Int): Product {
        return products.find { p -> p.id == productId }
            ?: throw ItemNotFoundException("Item with id $productId not available in inventory")
    }
}

class ItemNotFoundException(message: String) : Exception(message)
