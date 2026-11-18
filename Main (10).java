/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

public class Main
{

// Q1.1 - Main application: uses single + two-dimensional arrays
public class ProductSalesApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Single-dimensional array for product names
        String[] productNames = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};

        // Two-dimensional array: [3 products][3 months]
        int[][] sales = new int[3][3];

        // Capture sales for each product for 3 months
        for (int i = 0; i < productNames.length; i++) {
            for (int month = 0; month < 3; month++) {
                System.out.print("Enter number of sales for month " + (month + 1) +
                        " for " + productNames[i] + " mattress: ");
                sales[i][month] = scanner.nextInt();
            }
        }

        // Create Product and Print objects
        Product product = new Product(sales, productNames);
        PrintProduct printer = new PrintProduct();
        printer.printReport(product);

        scanner.close();
    }
}
	}
} 

