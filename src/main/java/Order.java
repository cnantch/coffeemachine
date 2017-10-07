public class Order {
    private String message;

    private Order(String message) {
        this.message = message;
    }

    public static Order createOrder(String message) {
        return new Order(message);
    }


    public String getMessage() {
        return message;
    }
}
