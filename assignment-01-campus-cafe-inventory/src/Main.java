import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Product[] products = new Product[10];

        int count = 0;

        int choice;

        do{
            System.out.println("\n--- Campus Cafe Inventory ---");
            System.out.println("1. Add product");
            System.out.println("2. Display all products");
            System.out.println("3. Total stock value");
            System.out.println("4. Average price");
            System.out.println("5. Restock a product");
            System.out.println("6. Duplicate a product");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            choice = sc.nextInt();

            sc.nextLine();

            if (choice < 0 || choice > 6) {
                System.out.println("Invalid choice, try again.");
            }


            switch (choice){
                case 1 :
                    System.out.println("=================================================");
                    System.out.println("                 ADD NEW PRODUCT                 ");
                    System.out.println("=================================================");

                    System.out.print("Enter Product Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    System.out.print("Enter Quantity: ");
                    int quantity = sc.nextInt();

                    sc.nextLine();

                    // TODO: if the array is full (count is 10), print a message
                    // TODO: else if price <= 0 or quantity < 0, print an error message
                    // TODO: otherwise create the Product with the parameterized
                    //       constructor, store it at products[count] and increase count

                    if (count == products.length) {
                        System.out.println("ERROR: Product inventory is full!");
                    }
                    else if (name == null || name.trim().isEmpty()) {
                        System.out.println("ERROR: Product name cannot be empty!");
                    }
                    else if (price <= 0 || quantity < 0) {
                        System.out.println("ERROR: Invalid price or quantity!");
                    }
                    else {
                        products[count] = new Product(name, price, quantity);

                        count++;

                        System.out.println("---------------------------------");
                        System.out.println("     SUCCESS: Product added!     ");
                        System.out.println("---------------------------------");

                        break;
                    }

                case 2 :
                    // TODO: if count is 0 print a message, otherwise loop from 0 to
                    //       count - 1 and call display() on each product
                    //       (print the number i + 1 before each one)
                    System.out.println("=================================================");
                    System.out.println("                 PRODUCT INVENTORY               ");
                    System.out.println("=================================================");

                    System.out.printf("%-5s %-18s %-12s %-10s%n",
                            "No.", "Product", "Price", "Quantity");

                    System.out.println("------------------------------------------------");

                    if (count == 0) {
                        System.out.println("            No products available!            ");
                    }
                    else {
                        for (int i = 0; i < count; i++) {
                            System.out.printf("%-5d ", i + 1);
                            products[i].display();
                        }
                    }
                    System.out.println("------------------------------------------------");

                    break;

                case 3:
                    System.out.println("=======================================================");
                    System.out.println("                     STOCK SUMMARY                     ");
                    System.out.println("=======================================================");

                    // TODO: loop over the stored products, add up stockValue()
                    //       and print the total (message if count is 0)

                    System.out.printf("%-18s %-12s %-10s %-12s%n",
                            "Product", "Price", "Quantity", "Stock Value");

                    System.out.println("------------------------------------------------------");

                    if (count == 0) {
                        System.out.println("                 No products available!            ");
                    }
                    else {
                        double totalStockValue = 0;

                        for (int i = 0; i < count; i++) {

                            System.out.printf("%-18s ", products[i].name);
                            System.out.printf("%-12.2f ", products[i].price);
                            System.out.printf("%-10d ", products[i].quantity);
                            System.out.printf("%-12.2f%n", products[i].stockValue());

                            totalStockValue += products[i].stockValue();
                        }

                        System.out.println("------------------------------------------------------");
                        System.out.printf("%-18s %-12s %-10s %-12s%n",
                                "TOTAL STOCK VALUE:", "", "", String.format("%.2f", totalStockValue));
                    }
                    System.out.println("------------------------------------------------------");
                    break;

                case 4:
                    System.out.println("=================================================");
                    System.out.println("             AVERAGE PRODUCT PRICE               ");
                    System.out.println("=================================================");
                    // TODO: calculate the average price as a double and print it
                    //       also print it rounded down using an explicit cast
                    if (count == 0) {
                        System.out.println("No products available!");
                    } else {
                        double totalPrice = 0;

                        for (int i = 0; i < count; i++) {
                            totalPrice += products[i].price;
                        }

                        double average = totalPrice / count;
                        int roundedDown = (int) average;

                        System.out.printf("Average Price: Rs. %.2f%n", average);
                        System.out.println("Rounded Price: Rs. " + roundedDown);
                    }

                    break;

                case 5:
                    System.out.println("=================================================");
                    System.out.println("                RESTOCK PRODUCT                  ");
                    System.out.println("=================================================");

                    if (count == 0) {
                        System.out.println("No products available!");
                        break;
                    }

                    System.out.print("Enter Product Number: ");
                    int num = sc.nextInt();

                    System.out.print("Enter Quantity to add: ");
                    int extra = sc.nextInt();
                    sc.nextLine();

                    // TODO: check num is between 1 and count and extra is above 0,
                    //       otherwise print an error; then add extra to the quantity
                    //       of products[num - 1]
                    System.out.println();

                    if (num < 1 || num > count) {
                        System.out.println("ERROR: Invalid product number!");
                    } else if (extra <= 0) {
                        System.out.println("ERROR: Quantity must be greater than 0!");
                    } else {
                        products[num - 1].quantity += extra;

                        System.out.println("---------------------------------");
                        System.out.println("SUCCESS: Product restocked!");
                        System.out.println("Product: " + products[num - 1].name);
                        System.out.println("Updated Quantity: " + products[num - 1].quantity);
                        System.out.println("---------------------------------");
                    }

                    break;


                case 6:
                    System.out.println("=================================================");
                    System.out.println("               DUPLICATE PRODUCT                 ");
                    System.out.println("=================================================");

                    if (count == 0) {
                        System.out.println("No products available!");
                        break;
                    }

                    System.out.print("Product number: ");
                    int n = sc.nextInt();
                    sc.nextLine();

                    // TODO: check n is between 1 and count (and the array is not full)
                    // TODO: create a copy of products[n - 1] with the copy constructor,
                    //       add " (copy)" to the copy's name, store it at
                    //       products[count] and increase count

                    if (n < 1 || n > count) {
                        System.out.println("ERROR: Invalid product number!");
                    } else if (count == products.length) {
                        System.out.println("ERROR: Product inventory is full!");
                    } else {
                        Product copy = new Product(products[n - 1]);
                        copy.name += " (copy)";

                        products[count] = copy;
                        count++;

                        System.out.println("---------------------------------");
                        System.out.println("SUCCESS: Product duplicated!");
                        System.out.println("New Product Name: " + copy.name);
                        System.out.println("---------------------------------");

                    }

                    break;

                case 0:
                    System.out.println("Goodbye!");
                    break;

            }

        }while (choice != 0);
    }
}