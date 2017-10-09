import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

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
        Assert.assertEquals("T:0:0", Order.createNewOrder(Drink.TEA, 0).getMessage());
    }

    @Test
    public void should_return_incorrect_order_when_the_customer_do_incorrect_order() throws Exception {
        Assert.assertEquals(Order.INCORRECT_ORDER, Order.createOrder("T").getMessage());
    }

    @Test
    public void should_return_the_cofee_and_the_sugar_and_the_stick_when_the_customer_ask_for_this() throws Exception {
        Assert.assertEquals("C:1:0", Order.createOrder(Drink.COFFEE.getName() + ":1:0").getMessage());
    }

    @Test
    public void should_return_the_cofee_and_two_sugars_and_the_stick_when_the_customer_ask_for_this() throws Exception {
        Assert.assertEquals("C:2:0", Order.createOrder(Drink.COFFEE.getName() + ":2:0").getMessage());
    }

    @Test
    public void should_return_the_chocolate_and_the_sugar_and_the_stick_when_the_customer_ask_for_this() throws Exception {
        Assert.assertEquals("H:1:0", Order.createOrder(Drink.CHOCOLATE.getName() + ":1:0").getMessage());
    }

    @Test
    public void should_return_incorrect_order_when_the_customer_do_incorrect_order_cofee() throws Exception {
        Assert.assertEquals(Order.INCORRECT_ORDER, Order.createOrder("C:1").getMessage());
    }

    @Test
    public void should_return_incorrect_order_when_the_customer_do_incorrect_order_cofee_stick() throws Exception {
        Assert.assertEquals(Order.INCORRECT_ORDER, Order.createOrder("C:1:1").getMessage());
    }

    @Test
    public void should_return_ok_when_the_customer_ask_for_the_chocolate() throws Exception {
        Order order = Order.createOrder(Drink.CHOCOLATE, 1, BigDecimal.valueOf(0.5));
        Assert.assertEquals("H:1:0", order.getMessage());
        Assert.assertEquals(Order.RESULT_OK, order.getResult());
    }

    @Test
    public void should_return_ko_when_the_customer_ask_for_the_chocolate() throws Exception {
        Order order = Order.createOrder(Drink.CHOCOLATE, 1, BigDecimal.valueOf(0.4));
        Assert.assertEquals("H:1:0", order.getMessage());
        Assert.assertEquals("KO,missing 0,1", order.getResult());
    }

    @Test
    public void should_return_ok_when_the_customer_ask_for_the_chocolate_with_price_upper() throws Exception {
        Order order = Order.createOrder(Drink.CHOCOLATE, 2, BigDecimal.valueOf(0.7));
        Assert.assertEquals("H:2:0", order.getMessage());
        Assert.assertEquals(Order.RESULT_OK, order.getResult());
    }


    @Test
    public void should_return_ok_when_the_customer_ask_for_the_cofee() throws Exception {
        Order order = Order.createOrder(Drink.COFFEE, 2, BigDecimal.valueOf(0.6));
        Assert.assertEquals("C:2:0", order.getMessage());
        Assert.assertEquals(Order.RESULT_OK, order.getResult());
    }


    @Test
    public void should_return_ko_when_the_customer_ask_for_the_cofee() throws Exception {
        Order order = Order.createOrder(Drink.COFFEE, 1, BigDecimal.valueOf(0.2));
        Assert.assertEquals("KO,missing 0,4", order.getResult());
    }

    @Test
    public void should_return_ok_when_the_customer_ask_for_the_coffee_with_price_upper() throws Exception {
        Order order = Order.createOrder(Drink.COFFEE, 1, BigDecimal.valueOf(0.7));
        Assert.assertEquals(Order.RESULT_OK, order.getResult());
    }

    @Test
    public void should_return_ok_when_the_customer_ask_for_the_tea() throws Exception {
        Order order = Order.createOrder(Drink.TEA, 0, BigDecimal.valueOf(0.4));
        Assert.assertEquals("T:0:0", order.getMessage());
        Assert.assertEquals(Order.RESULT_OK, order.getResult());
    }

    @Test
    public void should_return_ko_when_the_customer_ask_for_the_tea() throws Exception {
        Order order = Order.createOrder(Drink.TEA, 1, BigDecimal.valueOf(0.3));
        Assert.assertEquals(Order.RESULT_KO +"0,1", order.getResult());
    }

    @Test
    public void should_return_ok_when_the_customer_ask_for_the_tea_with_price_upper() throws Exception {
        Order order = Order.createOrder(Drink.TEA, 1, BigDecimal.valueOf(0.7));
        Assert.assertEquals(Order.RESULT_OK, order.getResult());
    }

    @Test
    public void should_return_the_orange_juice_when_the_customer_ask_the_orange_juice() throws Exception {
        Assert.assertEquals("O::", Order.createOrder(Drink.ORANGE_JUICE.getName() + "::").getMessage());
    }

    @Test
    public void should_return_incorrect_order_when_the_customer_ask_the_orange_juice_wrong() throws Exception {
        Assert.assertEquals(Order.INCORRECT_ORDER, Order.createOrder(Drink.ORANGE_JUICE.getName() + ":1:0").getMessage());
    }

    @Test
    public void should_return_the_orange_juice_when_the_customer_ask_the_orange_juice_with_the_good_price() throws Exception {
        Assert.assertEquals(Order.RESULT_OK, Order.createOrder(Drink.ORANGE_JUICE, 0, BigDecimal.valueOf(0.6)).getResult());
    }


    @Test
    public void should_return_incorrect_order__when_the_customer_ask_the_orange_juice_with_the_good_price() throws Exception {
        Assert.assertEquals(Order.INCORRECT_ORDER, Order.createOrder(Drink.ORANGE_JUICE, 1, BigDecimal.valueOf(0.6)).getMessage());
    }

    @Test
    public void should_return_ko_when_the_customer_ask_for_the_orange_with_the_wrong_price() throws Exception {
        Order order = Order.createOrder(Drink.ORANGE_JUICE, 0, BigDecimal.valueOf(0.3));
        Assert.assertEquals(Order.RESULT_KO +"0,3", order.getResult());
    }

    @Test
    public void should_return_the_cofee_when_the_customer_ask_for_this() throws Exception {
        Assert.assertEquals("C::", Order.createOrder("C::").getMessage());
    }

    @Test
    public void should_return_the_extra_hot_cofee_when_the_customer_ask_for_this() throws Exception {
        Assert.assertEquals("Ch::", Order.createOrder("Ch::").getMessage());
    }

    @Test
    public void should_return_the_extra_hot_chocolate_with_two_sugars_when_the_customer_ask_for_this() throws Exception {
        Assert.assertEquals("Hh:2:0", Order.createOrder("Hh:2:0").getMessage());
    }

    @Test
    public void should_return_the_extra_hot_tea_with_one_sugar_when_the_customer_ask_for_this() throws Exception {
        Assert.assertEquals("Th:1:0", Order.createOrder("Th:1:0").getMessage());
    }
}
