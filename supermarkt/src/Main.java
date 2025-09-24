//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    // object instances maken van Product classes
    Product bread = new Product("Bread", 2.95, 32);
    Product fruit = new Product("fruit", 1.45, 68);
    Product toiletPaper = new Product("Toilet paper", 4.79, 15);
    Product cheese = new Product("Cheese", 8.99, 54);

    // SuperMarkt object instance maken en vullen met de producten
    SuperMarket albertHeijn = new SuperMarket(bread, fruit, toiletPaper, cheese);

    SuperMarket superMarket; // moest volgens de opdracht gedeclareerd worden maar volgens mij niet noodzakelijk?
    Customer customer;  // moest volgens de opdracht gedeclareerd worden maar volgens mij niet noodzakelijk?

    Scanner scanner = new Scanner(System.in);

    String customerName;
    String productName;
    int amount;

    System.out.println("Welcome to the Grocery Store.");
    System.out.println("What is your name?");
    customerName = scanner.nextLine();
    Customer newCustomer = new Customer(customerName);

    newCustomer.goToSuperMarket(albertHeijn);

    System.out.println("Which product do you want to buy?");
    productName = scanner.nextLine();

    System.out.println("How many " + productName + " would you like?" );
    amount = scanner.nextInt();
    scanner.nextLine();

    newCustomer.buyItem(productName, amount);

}
