public class Order {
    public static final String INCORRECT_ORDER = "incorrect order";
    private String message;

    private Order(String message) {
        this.message = message;
    }

    public static Order createOrder(String message) {
        if (!message.startsWith("M:") && !message.startsWith("T:") && !message.startsWith("C:")
                && !message.startsWith("H:")) {
            return new Order(INCORRECT_ORDER);
        }
        return new Order(message);
    }


    public String getMessage() {
        return message;
    }
}
