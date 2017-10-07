public class Order {
    private String message;

    private Order(String message) {
        this.message = message;
    }

    public static Order createOrder(String message) {
        if (!message.startsWith("M:") && !message.startsWith("T:")) {
            return new Order("incorrect order");
        }
        return new Order(message);
    }


    public String getMessage() {
        return message;
    }
}
