import java.util.Scanner;

public class FinancialForecasting {

    // Recursive method to calculate future value
    public static double calculateFutureValue(double initialValue, double growthRate, int years) {
        // Base case: when years is 0, return the initial value
        if (years == 0) {
            return initialValue;
        }
        // Recursive case: apply the growth rate for one year and call recursively
        return calculateFutureValue(initialValue * (1 + growthRate), growthRate, years - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter the initial value: ");
        double initialValue = scanner.nextDouble();

        System.out.print("Enter the growth rate (as a decimal, e.g., 0.05 for 5%): ");
        double growthRate = scanner.nextDouble();

        System.out.print("Enter the number of years for forecasting: ");
        int years = scanner.nextInt();

        double futureValue = calculateFutureValue(initialValue, growthRate, years);

        System.out.printf("The predicted future value after %d years is: %.2f%n", years, futureValue);

        scanner.close();
    }
}
