import org.junit.Assert;
import org.junit.Test;

public class OrderTest {

    @Test
    public void should_return_empty_message_when_the_customer_ask_empty_message() throws Exception {
        Assert.assertEquals("M:", Order.createOrder("M:").getMessage());
    }

    @Test
    public void should_return_any_message_when_the_customer_ask_any_message() throws Exception {
        Assert.assertEquals("M: i know what i want", Order.createOrder("M: i know what i want").getMessage());
    }

    @Test
    public void should_return_the_tea_when_the_customer_ask_the_tea() throws Exception {
        Assert.assertEquals(Drink.TEA.getName()+":0:0", Order.createOrder("T:0:0").getMessage());
    }

    @Test
    public void should_return_incorrect_order_when_the_customer_do_incorrect_order() throws Exception {
        Assert.assertEquals(Order.INCORRECT_ORDER, Order.createOrder("T").getMessage());
    }

    @Test
    public void should_return_the_cofee_and_the_sugar_and_the_stick_when_the_customer_ask_for_this() throws Exception {
        Assert.assertEquals("C:1:0", Order.createOrder(Drink.COFFEE.getName()+":1:0").getMessage());
    }
    @Test
    public void should_return_the_cofee_and_two_sugars_and_the_stick_when_the_customer_ask_for_this() throws Exception {
        Assert.assertEquals("C:2:0", Order.createOrder(Drink.COFFEE.getName()+":2:0").getMessage());
    }

    @Test
    public void should_return_the_chocolate_and_the_sugar_and_the_stick_when_the_customer_ask_for_this() throws Exception {
        Assert.assertEquals("H:1:0", Order.createOrder(Drink.CHOCOLATE.getName()+":1:0").getMessage());
    }

    @Test
    public void should_return_incorrect_order_when_the_customer_do_incorrect_order_cofee() throws Exception {
        Assert.assertEquals(Order.INCORRECT_ORDER, Order.createOrder("C:1").getMessage());
    }

    @Test
    public void should_return_incorrect_order_when_the_customer_do_incorrect_order_cofee_stick() throws Exception {
        Assert.assertEquals(Order.INCORRECT_ORDER, Order.createOrder("C:1:1").getMessage());
    }
}
