import java.util.Scanner;

class Order {
    private String orderId;
    private String customerName;
    private double totalPrice;

    public Order(String orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", customerName=" + customerName + ", totalPrice=" + totalPrice + "]";
    }
}

class SortingAlgorithms {

    // Bubble Sort
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    // Swap orders[j] and orders[j + 1]
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    // Quick Sort
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() <= pivot) {
                i++;
                // Swap orders[i] and orders[j]
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        // Swap orders[i + 1] and orders[high]
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }
}

public class SortingCustomerOrders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Order[] orders = new Order[0]; // Initial empty array

        boolean exit = false;

        while (!exit) {
            System.out.println("\nSorting Customer Orders:");
            System.out.println("1. Add Orders");
            System.out.println("2. Sort Orders with Bubble Sort");
            System.out.println("3. Sort Orders with Quick Sort");
            System.out.println("4. Display Orders");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the number of orders to add: ");
                    int numOrders = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    // Resize the array to accommodate new orders
                    Order[] newOrders = new Order[orders.length + numOrders];

                    // Copy existing orders
                    System.arraycopy(orders, 0, newOrders, 0, orders.length);

                    for (int i = 0; i < numOrders; i++) {
                        System.out.println("Enter details for order " + (i + 1) + ":");
                        System.out.print("Order ID: ");
                        String orderId = scanner.nextLine();
                        System.out.print("Customer Name: ");
                        String customerName = scanner.nextLine();
                        System.out.print("Total Price: ");
                        double totalPrice = scanner.nextDouble();
                        scanner.nextLine(); // Consume newline

                        newOrders[orders.length + i] = new Order(orderId, customerName, totalPrice);
                    }

                    orders = newOrders;

                    System.out.println("Orders added successfully.");
                    break;

                case 2:
                    if (orders.length == 0) {
                        System.out.println("No orders to sort.");
                    } else {
                        SortingAlgorithms.bubbleSort(orders);
                        System.out.println("Orders sorted using Bubble Sort.");
                    }
                    break;

                case 3:
                    if (orders.length == 0) {
                        System.out.println("No orders to sort.");
                    } else {
                        SortingAlgorithms.quickSort(orders, 0, orders.length - 1);
                        System.out.println("Orders sorted using Quick Sort.");
                    }
                    break;

                case 4:
                    if (orders.length == 0) {
                        System.out.println("No orders to display.");
                    } else {
                        System.out.println("Orders:");
                        for (Order order : orders) {
                            System.out.println(order);
                        }
                    }
                    break;

                case 5:
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
