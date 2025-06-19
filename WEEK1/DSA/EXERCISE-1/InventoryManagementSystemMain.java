import java.util.HashMap;
import java.util.Scanner;

class Product {
    private String productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product [productId=" + productId + ", productName=" + productName + 
                ", quantity=" + quantity + ", price=" + price + "]";
    }
}

class InventoryManagementSystem {
    private HashMap<String, Product> inventory;

    public InventoryManagementSystem() {
        inventory = new HashMap<>();
    }

    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
    }

    public void updateProduct(String productId, Product updatedProduct) {
        if (inventory.containsKey(productId)) {
            inventory.put(productId, updatedProduct);
        } else {
            System.out.println("Product not found in inventory.");
        }
    }

    public void deleteProduct(String productId) {
        if (inventory.containsKey(productId)) {
            inventory.remove(productId);
        } else {
            System.out.println("Product not found in inventory.");
        }
    }

    public void displayInventory() {
        for (Product product : inventory.values()) {
            System.out.println(product);
        }
    }
}

public class InventoryManagementSystemMain {
    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Inventory Management System:");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Display Inventory");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    String productId = scanner.nextLine();
                    System.out.print("Enter Product Name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    ims.addProduct(new Product(productId, productName, quantity, price));
                    break;

                case 2:
                    System.out.print("Enter Product ID to update: ");
                    productId = scanner.nextLine();
                    System.out.print("Enter new Product Name: ");
                    productName = scanner.nextLine();
                    System.out.print("Enter new Quantity: ");
                    quantity = scanner.nextInt();
                    System.out.print("Enter new Price: ");
                    price = scanner.nextDouble();
                    ims.updateProduct(productId, new Product(productId, productName, quantity, price));
                    break;

                case 3:
                    System.out.print("Enter Product ID to delete: ");
                    productId = scanner.nextLine();
                    ims.deleteProduct(productId);
                    break;

                case 4:
                    System.out.println("Current Inventory:");
                    ims.displayInventory();
                    break;

                case 5:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        }

        scanner.close();
    }
}
