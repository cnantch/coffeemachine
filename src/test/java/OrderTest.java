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
        Assert.assertEquals("T:0:0", Order.createOrder("T:0:0").getMessage());
    }

    @Test
    public void should_return_incorrect_order_when_the_customer_do_incorrect_order() throws Exception {
        Assert.assertEquals("incorrect order", Order.createOrder("T").getMessage());
    }
}
