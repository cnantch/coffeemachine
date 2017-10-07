public enum Drink {

    TEA("T", 0.4), COFFEE("C", 0.6), CHOCOLATE("H", 0.5);


    private final String name;
    private final double price;

    Drink(String name, double price) {

        this.name = name;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
