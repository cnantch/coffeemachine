public enum Drink {

    TEA("T", 0.4);


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
