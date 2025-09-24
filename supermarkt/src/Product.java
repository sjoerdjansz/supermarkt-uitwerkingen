public class Product {
    String name;
    double price;
    int amount;

    public Product(String name, double price, int amount) {
        if(name == "" || name == null) {
            throw new IllegalArgumentException("Product name invalid");
        }

        if (price <= 0) {
            throw   new IllegalArgumentException("Price can't be zero or less than zero");
        }

        if (amount < 0) {
            throw new IllegalArgumentException("Stock count can't be a negative number");
        }
        this.name = name;
        this.price = price;
        this.amount = amount;
    }
}
