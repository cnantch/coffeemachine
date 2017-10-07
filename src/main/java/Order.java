import java.util.regex.Pattern;

public class Order {

    public static final String INCORRECT_ORDER = "incorrect order";
    public static final Pattern VALIDATION_ORDER_PATTERN = Pattern.compile("M:.*|(^(T|C|H):[0-9]:0)");
    private String message;

    private Order(String message) {
        this.message = message;
    }

    public static Order createOrder(String message) {
        if (!VALIDATION_ORDER_PATTERN.matcher(message).matches()) {
            return new Order(INCORRECT_ORDER);
        }
        return new Order(message);
    }


    public String getMessage() {
        return message;
    }
}
