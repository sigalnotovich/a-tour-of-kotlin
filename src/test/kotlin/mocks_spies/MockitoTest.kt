package mocks_spies

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import kotlin.test.assertEquals

class MockitoTest {

    @Mock lateinit var repository: OrderRepository
    @Mock lateinit var validateOrder: OrderValidator
    @Mock lateinit var shippingClient: ShippingClient


    lateinit var unitUnderTest: Service

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        unitUnderTest = Service(
            repository,
            validateOrder,
            shippingClient
        )
    }

    @After fun cleanup(){
        ordersList.clear()
    }

    // the triple A format
    @Test fun `given a invalid order, should validate, send to svc shipping and update status`(){
        //              ARRANGE
        val order = OrderModel("pending", "iddqd", 123)
        Mockito.`when`(
            repository.getById(123)
        ).thenReturn(
            order
        )

        //              ACT
        val actual = unitUnderTest.shipOrder(123)

        //              ASSERT
        Mockito.verify(validateOrder).invoke(order)
        Mockito.verify(shippingClient).send(order)
        Mockito.verify(repository).update(order)
        assertEquals("sent",actual.status)
    }

    @Test fun `spies are awesome, but often are a code smell of badly designed code`(){
        val repoSpy = Mockito.spy(OrderRepository(DbClient()))
        //todo: step into spy factory and read the docs
        val order = OrderModel("pending", "iddqd", 123)
        val uut = Service(repoSpy, validateOrder, shippingClient)
        repoSpy.insert(order)
        Mockito.`when`(
            repoSpy.update(order)
        ).then { invocation ->
            val o = invocation.arguments.first() as OrderModel
            println("this will also work with mocks !!! ${o.status}")
        }

        val actual = uut.shipOrder(order.id)

        assertEquals("sent",actual.status)
        Mockito.verify(repoSpy).getById(order.id)
    }
}