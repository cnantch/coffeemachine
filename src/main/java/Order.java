import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.regex.Pattern;

public class Order {

    public static final String INCORRECT_ORDER = "incorrect order";
    public static final Pattern VALIDATION_ORDER_PATTERN = Pattern.compile("M:.*|(^(T|C|H)h{0,1}:[0-9]{0,1}:0{0,1})|O::");
    public static final DecimalFormat format = new DecimalFormat("#,##0.0");
    public static final String RESULT_OK = "OK";
    public static final String RESULT_KO = "KO,missing ";

    private Drink drink;
    private int nbSugars;
    private String message;
    private BigDecimal price;

    private Order(String message) {
        this.message = message;
    }

    public Order(String message, BigDecimal price) {
        this.message = message;
        this.price = price;
    }

    public static Order createOrder(String message) {
        if (!VALIDATION_ORDER_PATTERN.matcher(message).matches()) {
            return new Order(INCORRECT_ORDER);
        }
        return new Order(message);
    }

    public static Order createOrder(Drink drink, int nbSugars, BigDecimal price) {
        Order order = createNewOrder(drink, nbSugars);
        order.price = price;
        return order;
    }

    public String getMessage() {
        return message;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public static Order createNewOrder(Drink drink, int nbSugars) {
        Order order = createOrder(drink.getName()+":"+nbSugars+":"+0);
        order.drink = drink;
        order.nbSugars = nbSugars;
        return order;
    }

    public String getResult() {

        if (price.doubleValue() >= drink.getPrice().doubleValue()) {
            return RESULT_OK;
        }
        return RESULT_KO + format.format(drink.getPrice().subtract(price));
    }
}
