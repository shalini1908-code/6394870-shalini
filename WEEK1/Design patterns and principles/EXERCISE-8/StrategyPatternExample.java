import java.util.Scanner;

// Define the Strategy Interface
interface PaymentStrategy {
    void pay(double amount);
}

// Implement Concrete Strategies
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Processing credit card payment of Rs." + amount + " using card number " + cardNumber + ".");
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Processing PayPal payment of Rs." + amount + " using email " + email + ".");
    }
}

// Implement Context Class
class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void executePayment(double amount) {
        paymentStrategy.pay(amount);
    }
}

// Main class to test the Strategy Pattern
public class StrategyPatternExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PaymentContext paymentContext = new PaymentContext();

        while (true) {
            System.out.println("\nSelect Payment Method:");
            System.out.println("1. Credit Card");
            System.out.println("2. PayPal");
            System.out.println("3. Exit");
            System.out.print("Enter the number of the payment method: ");
            int choice = scanner.nextInt();

            if (choice == 3) {
                System.out.println("Exiting");
                break;
            }

            System.out.print("Enter the amount to pay (in Rs.): ");
            double amount = scanner.nextDouble();

            switch (choice) {
                case 1:
                    System.out.print("Enter credit card number: ");
                    String cardNumber = scanner.next();
                    paymentContext.setPaymentStrategy(new CreditCardPayment(cardNumber));
                    paymentContext.executePayment(amount);
                    break;
                case 2:
                    System.out.print("Enter PayPal email: ");
                    String email = scanner.next();
                    paymentContext.setPaymentStrategy(new PayPalPayment(email));
                    paymentContext.executePayment(amount);
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }

        scanner.close();
    }
}
