import java.sql.PreparedStatement;
import java.util.List;

import static java.lang.System.in;

public class SuperMarket {

    String name;
    List<Product> productList;

    public SuperMarket(String name, List<Product> productList) {
        if (productList == null) {
            throw new IllegalArgumentException("List can't be null!");
        }

        this.name = name;
        this.productList = productList;
    }

    // helper method
    public  void sellItem(Product product, int amount) {
        if (amount <= 0) {
            System.out.println("Can't buy nothing...");
            return;
        }
        if (amount <= product.amount) {
            double totalCost = Math.round(product.price * amount * 100.0) / 100.0;
            System.out.println(
                    "You bought " + amount + " " + product.name + " for " + totalCost +
                    " euro total.");
            product.amount = product.amount - amount;
            System.out.println(product.amount + " left in stock.");
            reStockItem(product.name, amount);
        } else {
            System.out.println(
                    "You cannot buy " + amount + " " + product.name + ", we only have " + product.amount +
                    " " + product.name + " in stock.");
        }
    }

    public void reStockItem(String productName, int amount) {
        for (int i = 0; i < this.productList.size(); i++) {
            if (productName.equalsIgnoreCase(this.productList.get(i).name)) {
                System.out.println("Product found: " + productName);
                this.productList.get(i).amount += amount;
                System.out.println(productName + " restocked by " + amount);
                return;
            }
        }
        System.out.println("Product not found, can't restock item because " + productName +
                           " is not available in this store.");
    }

    public void showInventory() {
        for (Product product : this.productList) {
            System.out.println(product.name);
        }
    }

}
