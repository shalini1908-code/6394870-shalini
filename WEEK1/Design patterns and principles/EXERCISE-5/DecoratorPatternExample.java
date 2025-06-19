import java.util.Scanner;

// Step 2: Define Component Interface
interface Notifier {
    void send(String message);
}

// Step 3: Implement Concrete Component
class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}

// Step 4: Implement Decorator Classes
abstract class NotifierDecorator implements Notifier {
    protected Notifier wrapped;

    public NotifierDecorator(Notifier wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public void send(String message) {
        wrapped.send(message);
    }
}

class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier wrapped) {
        super(wrapped);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Sending SMS: " + message);
    }
}

class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier wrapped) {
        super(wrapped);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Sending Slack message: " + message);
    }
}

// Step 5: Test the Decorator Implementation
public class DecoratorPatternExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the notification message: ");
        String message = scanner.nextLine();

        Notifier notifier = new EmailNotifier();

        System.out.println("Select additional notification channels (comma separated):");
        System.out.println("1. SMS");
        System.out.println("2. Slack");
        System.out.print("Enter your choice: ");
        String[] choices = scanner.nextLine().split(",");

        for (String choice : choices) {
            switch (choice.trim()) {
                case "1":
                    notifier = new SMSNotifierDecorator(notifier);
                    break;
                case "2":
                    notifier = new SlackNotifierDecorator(notifier);
                    break;
                default:
                    System.out.println("Invalid choice: " + choice);
                    break;
            }
        }

        notifier.send(message);
        scanner.close();
    }
}
