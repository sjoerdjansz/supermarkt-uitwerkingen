public class SuperMarket {

    Product bread;
    Product fruit;
    Product toiletPaper;
    Product cheese;

    public SuperMarket(Product bread, Product fruit, Product toiletPaper, Product cheese) {
        if (bread == null) {
            throw new IllegalArgumentException("Bread can't be null!");
        }
        if (fruit == null) {
            throw new IllegalArgumentException("Fruit can't be null!");
        }
        if (toiletPaper == null) {
            throw new IllegalArgumentException("Toilet paper can't be null!");
        }
        if (cheese == null) {
            throw new IllegalArgumentException("Cheese can't be null!");
        }

        this.bread = bread;
        this.fruit = fruit;
        this.toiletPaper = toiletPaper;
        this.cheese = cheese;
    }

    // helper method
    public static void buyItem(Product product, int amount) {
        if (amount <= 0) {
            System.out.println("Can't buy nothing...");
            return;
        }
        if (amount <= product.amount) {
            System.out.println(
                    "You bought " + amount + " " + product.name + " for " + product.price * amount +
                    " euro total.");
            product.amount = product.amount - amount;
            System.out.println(product.amount + " left in stock.");
        } else {
            System.out.println(
                    "You cannot buy " + amount + " " + product.name + ", we only have " + product.amount +
                    " " + product.name + " in stock.");
        }
    }

    public void buyBread(int amount) {
        buyItem(this.bread, amount);
    }

    public void buyFruit(int amount) {
        buyItem(this.fruit, amount);
    }

    public void buyToiletPaper(int amount) {
        buyItem(this.toiletPaper, amount);
    }

    public void buyCheese(int amount) {
        buyItem(this.cheese, amount);
    }

}
