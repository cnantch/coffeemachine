import java.util.regex.Pattern;

public class Order {

    public static final String INCORRECT_ORDER = "incorrect order";
    public static final Pattern VALIDATION_ORDER_PATTERN = Pattern.compile("M:.*|(^(T|C|H):[0-9]:0)");

    private Drink drink;
    private int nbSugars;
    private String message;
    private double price;

    private Order(String message) {
        this.message = message;
    }

    public Order(String message, double price) {
        this.message = message;
        this.price = price;
    }

    public static Order createOrder(String message) {
        if (!VALIDATION_ORDER_PATTERN.matcher(message).matches()) {
            return new Order(INCORRECT_ORDER);
        }
        return new Order(message);
    }

    public static Order createOrder(Drink drink, int nbSugars, double price) {
        Order order = createNewOrder(drink, nbSugars);
        order.price = price;
        return order;
    }

    public String getMessage() {
        return message;
    }

    public double getPrice() {
        return price;
    }

    public static Order createNewOrder(Drink drink, int nbSugars) {
        Order order = createOrder(drink.getName()+":"+nbSugars+":"+0);
        order.drink = drink;
        order.nbSugars = nbSugars;
        return order;
    }

    public String getResult() {
        if (price == drink.getPrice()) {
            return "OK";
        }
        return "KO";
    }
}
