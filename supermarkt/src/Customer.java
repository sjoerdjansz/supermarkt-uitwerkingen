import java.util.Objects;

public class Customer {
    String name;
    SuperMarket supermarket;

    public Customer(String name) {
        this.name = name;
    }


    public void goToSuperMarket(SuperMarket supermarket) {
        if (supermarket == null) {
            throw new IllegalArgumentException("Store/Supermarket can't be null");
        }
        this.supermarket = supermarket;
    }

    public void buyItem(String productName, int amount) {
        for (int i = 0; i < supermarket.productList.size(); i++) {
            if (productName.equalsIgnoreCase(supermarket.productList.get(i).name)) {
                SuperMarket.sellItem(supermarket.productList.get(i), amount);
                return;
            }
        }
        System.out.println(supermarket.name + " does not sell " + productName);
    }
}
