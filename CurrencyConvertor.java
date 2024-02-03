import java.util.Scanner;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CurrencyConvertor {
    private static final String API_BASE_URL = "https://api.exchangerate-api.com/v4/latest/";

    public static double getExchangeRate(String baseCurrency, String targetCurrency) {
        try {
            URL url = new URL(API_BASE_URL + baseCurrency);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();

            // Parse JSON response
            String jsonResponse = response.toString();
            double exchangeRate = Double.parseDouble(jsonResponse.split("\"" + targetCurrency + "\":")[1].split(",")[0]);

            return exchangeRate;
        } catch (Exception e) {
            System.out.println("Error fetching exchange rates: " + e.getMessage());
            return -1.0; // Indicates an error
        }
    }

    public static double convertCurrency(double amount, double exchangeRate) {
        return amount * exchangeRate;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char continueOption;

        do {
            // Step 1: Allow the user to choose source and target currencies
            System.out.print("Enter the source currency code (INR/USD/EUR): ");
            String sourceCurrency = scanner.next().toUpperCase();

            System.out.print("Enter the target currency code (INR/USD/EUR): ");
            String targetCurrency = scanner.next().toUpperCase();

            // Step 2: Fetch real-time exchange rates
            double exchangeRate = getExchangeRate(sourceCurrency, targetCurrency);

            if (exchangeRate != -1.0) {
                // Step 3: Take input from the user for the amount
                System.out.print("Enter the amount to convert: ");
                double amount = scanner.nextDouble();

                // Step 4: Convert the input amount using the fetched exchange rate
                double convertedAmount = convertCurrency(amount, exchangeRate);

                // Step 5: Display the result
                System.out.printf("%s %.2f is equal to %s %.2f%n", sourceCurrency, amount, targetCurrency, convertedAmount);
            } else {
                System.out.println("Failed to fetch exchange rates. Please try again.");
            }

            // Ask the user if they want to continue
            System.out.print("Do you want to continue? (y/n): ");
            continueOption = scanner.next().charAt(0);

        } while (Character.toUpperCase(continueOption) == 'Y');

        scanner.close();
    }
}
