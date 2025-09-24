public class Customer {
    String name;
    SuperMarket supermarket;

    public Customer(String name) {
        this.name = name;
    }

    public void goToSuperMarket(SuperMarket supermarket) {
        this.supermarket = supermarket;
    }

    public void buyItem(String productName, int amount) {
        System.out.println(this.name + " is currently shopping for " + productName);
        if(productName.equalsIgnoreCase("bread")) {
            supermarket.buyBread(amount);
        } else if(productName.equalsIgnoreCase("cheese")) {
            supermarket.buyCheese(amount);
        } else if(productName.equalsIgnoreCase("fruit")) {
            supermarket.buyFruit(amount);
        } else if(productName.equalsIgnoreCase("toilet paper")) {
            supermarket.buyToiletPaper(amount);
        } else {
            System.out.println(productName + " not available");
        }
    }
}
