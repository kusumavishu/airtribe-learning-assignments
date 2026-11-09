public class Product {
    static int totalProducts = 0;

    String name;
    double price;
    int quantity;

    // 1. No-argument constructor: sets default values
    Product() {
        name = "Unknown";
        price = 0;
        quantity = 0;
        totalProducts++;
    }

    // 2. Parameterized constructor
    Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        totalProducts++;
    }

    // 3. Copy constructor for Duplicate
    Product(Product other) {
        // TODO: copy name, price and quantity from other into this object
        // TODO: remember to increase totalProducts too
        this.name = other.name;
        this.price = other.price;
        this.quantity = other.quantity;

        totalProducts++;
    }

    double stockValue() {
        return price * quantity;
    }

    void display() {
        System.out.printf("%-5s %-18s %-12.2f %-10d%n",
                "",
                name,
                price,
                quantity
        );
    }

}
