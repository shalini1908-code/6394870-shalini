import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Step 2: Define Subject Interface
interface Stock {
    void registerObserver(Observer observer);
    void deregisterObserver(Observer observer);
    void notifyObservers();
}

// Step 4: Define Observer Interface
interface Observer {
    void update(double price);
}

// Step 3: Implement Concrete Subject
class StockMarket implements Stock {
    private List<Observer> observers;
    private double price;

    public StockMarket() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
        System.out.println("Observer registered.");
    }

    @Override
    public void deregisterObserver(Observer observer) {
        observers.remove(observer);
        System.out.println("Observer deregistered.");
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(price);
        }
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }
}

// Step 5: Implement Concrete Observers
class MobileApp implements Observer {
    private String name;

    public MobileApp(String name) {
        this.name = name;
    }

    @Override
    public void update(double price) {
        System.out.println(name + " received stock price update: Rs." + price);
    }
}

class WebApp implements Observer {
    private String name;

    public WebApp(String name) {
        this.name = name;
    }

    @Override
    public void update(double price) {
        System.out.println(name + " received stock price update: Rs." + price);
    }
}

// Step 6: Test the Observer Implementation
public class ObserverPatternExample {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Register Mobile App Observer");
            System.out.println("2. Register Web App Observer");
            System.out.println("3. Deregister Mobile App Observer");
            System.out.println("4. Deregister Web App Observer");
            System.out.println("5. Set Stock Price");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Mobile App name: ");
                    String mobileAppName = scanner.nextLine();
                    stockMarket.registerObserver(new MobileApp(mobileAppName));
                    break;

                case 2:
                    System.out.print("Enter Web App name: ");
                    String webAppName = scanner.nextLine();
                    stockMarket.registerObserver(new WebApp(webAppName));
                    break;

                case 3:
                    // In a real application, you would need to keep references to registered observers to deregister them
                    System.out.println("Deregistration functionality is not implemented in this example.");
                    break;

                case 4:
                    // Similar to case 3, you would need to keep references to deregister
                    System.out.println("Deregistration functionality is not implemented in this example.");
                    break;

                case 5:
                    System.out.print("Enter new stock price (Rs.): ");
                    double newPrice = scanner.nextDouble();
                    stockMarket.setPrice(newPrice);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
