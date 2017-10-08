import java.math.BigDecimal;

public enum Drink {

    TEA("T", new BigDecimal(0.4)), COFFEE("C", new BigDecimal(0.6)), CHOCOLATE("H", new BigDecimal(0.5)), ORANGE_JUICE("O", new BigDecimal(0.6) );


    private final String name;
    private final BigDecimal price;

    Drink(String name, BigDecimal price) {

        this.name = name;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
