private static SuperMarket pickStore(Scanner scanner, Map<String, SuperMarket> stores, String prompt) {
    System.out.println(prompt);
    System.out.println("[Health Mart] -- [Browns Bakery] -- [Fresh Greens]");

    String input = scanner.nextLine().trim();

    SuperMarket store = stores.get(input);

    if (store == null) {
        System.out.println("Unknown store: " + input);
    }
    return store;
}

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
    int amount;

    System.out.println("What is your name?");
    customerName = scanner.nextLine().trim();

    Customer newCustomer = new Customer(customerName);

    boolean isShopping = true;


    while (isShopping) {
        System.out.println("What do you want to do?");
        System.out.println("1 - Pick a store");
        System.out.println("2 - Buy something");
        System.out.println("3 - Restock a product");
        System.out.println("4 - Exit");

        int choice = scanner.nextInt();

        scanner.nextLine();

        switch (choice) {
            case 1: {
                SuperMarket storeChoice = pickStore(scanner, stores, "Which store do you want to go to?");
                if (storeChoice != null) {
                    newCustomer.goToSuperMarket(storeChoice);
                    System.out.println("Welcome to " + storeChoice.name);
                }
                break;
            }
            case 2:
                SuperMarket store = newCustomer.supermarket;
                if (store == null) {
                    System.out.println("Pick a store first");
                    break;
                }

                System.out.println("Which product do you want to buy?");
                store.showInventory();

                productName = scanner.nextLine().trim();

                System.out.println("How many " + productName + " would you like?");
                amount = scanner.nextInt();
                scanner.nextLine();
                newCustomer.buyItem(productName, amount);
                break;
            case 3: {
                SuperMarket storeChoice = pickStore(scanner, stores,
                                                    "Which store would you like to restock?");
                if (storeChoice != null) {
                    newCustomer.goToSuperMarket(storeChoice);
                    System.out.println("Which item do you want to restock?");
                    storeChoice.showInventory();
                    String item = scanner.nextLine();
                    System.out.println("How many " + item + " would you like to restock?");
                    amount = scanner.nextInt();
                    scanner.nextLine();
                    storeChoice.reStockItem(item, amount);
                }
                break;
            }
            case 4:
                System.out.println("Thanks for shopping with us " + customerName);
                isShopping = false;
                break;
            default:
                System.out.println("Invalid input. Try again.");
                break;
        }

    }
}
