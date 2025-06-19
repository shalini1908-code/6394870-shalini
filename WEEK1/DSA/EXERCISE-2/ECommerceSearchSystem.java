import java.util.Arrays;
import java.util.Scanner;

class Product {
    private String productId;
    private String productName;
    private String category;

    public Product(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product [productId=" + productId + ", productName=" + productName + ", category=" + category + "]";
    }
}

class SearchAlgorithms {

    public static Product linearSearch(Product[] products, String searchId) {
        for (Product product : products) {
            if (product.getProductId().equals(searchId)) {
                return product;
            }
        }
        return null; // Product not found
    }

    public static Product binarySearch(Product[] products, String searchId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (products[mid].getProductId().equals(searchId)) {
                return products[mid];
            }
            if (products[mid].getProductId().compareTo(searchId) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null; // Product not found
    }
}

public class ECommerceSearchSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Product[] products = new Product[0]; // Initial empty array

        boolean exit = false;

        while (!exit) {
            System.out.println("\nE-Commerce Platform Search Function:");
            System.out.println("1. Add Products");
            System.out.println("2. Linear Search");
            System.out.println("3. Binary Search");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the number of products to add: ");
                    int numProducts = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    // Resize the array to accommodate new products
                    Product[] newProducts = Arrays.copyOf(products, products.length + numProducts);

                    for (int i = 0; i < numProducts; i++) {
                        System.out.println("Enter details for product " + (i + 1) + ":");
                        System.out.print("Product ID: ");
                        String productId = scanner.nextLine();
                        System.out.print("Product Name: ");
                        String productName = scanner.nextLine();
                        System.out.print("Category: ");
                        String category = scanner.nextLine();

                        newProducts[products.length + i] = new Product(productId, productName, category);
                    }

                    products = newProducts;

                    // Sort products by productId for binary search
                    Arrays.sort(products, (p1, p2) -> p1.getProductId().compareTo(p2.getProductId()));

                    System.out.println("Products added successfully.");
                    break;

                case 2:
                    System.out.print("Enter Product ID for linear search: ");
                    String searchIdLinear = scanner.nextLine();
                    Product foundProductLinear = SearchAlgorithms.linearSearch(products, searchIdLinear);
                    System.out.println("Linear Search Result: " + (foundProductLinear != null ? foundProductLinear : "Product not found"));
                    break;

                case 3:
                    System.out.print("Enter Product ID for binary search: ");
                    String searchIdBinary = scanner.nextLine();
                    Product foundProductBinary = SearchAlgorithms.binarySearch(products, searchIdBinary);
                    System.out.println("Binary Search Result: " + (foundProductBinary != null ? foundProductBinary : "Product not found"));
                    break;

                case 4:
                    exit = true;
                    System.out.println("Exiting the system.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
