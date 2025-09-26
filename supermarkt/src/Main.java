//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    // object instances maken van Product classes binnen ArrayLists
    ArrayList<Product> bakery = new ArrayList<Product>();
    bakery.add(new Product("Whole wheat bread", 2.95, 32));
    bakery.add(new Product("White bread", 1.99, 20));
    bakery.add(new Product("Crossaint", 3.00, 55));
    bakery.add(new Product("Baguette", 2.99, 25));

    ArrayList<Product> produceMarket = new ArrayList<Product>();
    produceMarket.add(new Product("Banana", 0.99, 18));
    produceMarket.add(new Product("Apple", 1.10, 53));
    produceMarket.add(new Product("Orange", 1.20, 87));
    produceMarket.add(new Product("Kiwi", 1.75, 30));

    ArrayList<Product> drugstore = new ArrayList<Product>();
    drugstore.add(new Product("Toilet paper", 4.79, 15));
    drugstore.add(new Product("Paracetamol", 5.99, 38));
    drugstore.add(new Product("Tooth paste", 4.25, 102));
    drugstore.add(new Product("Soap", 3.00, 12));

    HashMap<String, SuperMarket> stores = new HashMap<String, SuperMarket>();

    stores.put("Health Mart", new SuperMarket("Health Mart", drugstore));
    stores.put("Browns Bakery", new SuperMarket("Browns Bakery", bakery));
    stores.put("Fresh Greens", new SuperMarket("Fresh Greens", produceMarket));

    Scanner scanner = new Scanner(System.in);

    String customerName;
    String productName;
    String store;
    int amount;

    System.out.println("What is your name?");
    customerName = scanner.nextLine().trim();
    Customer newCustomer = new Customer(customerName);

    System.out.println("Which store would you like to visit?");
    System.out.println("[Health Mart] -- [Browns Bakery] -- [Fresh Greens]");
    store = scanner.nextLine().trim();
    System.out.println("STORE TYPED: " + store);

    newCustomer.goToSuperMarket(stores.get(store));

    System.out.println("What would you like to buy?");
    stores.get(store).showInventory();

    productName = scanner.nextLine().trim();

    System.out.println("How many " + productName + " would you like?" );
    amount = scanner.nextInt();
    scanner.nextLine();

    newCustomer.buyItem(productName, amount);

//    stores.get(store).reStockItem(productName, amount);

}
