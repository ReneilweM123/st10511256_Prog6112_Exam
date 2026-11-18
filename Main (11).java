/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

public class Main
{

// Q1.2 
// Product class implements IProduct - stores sales in 2D array
// sales[product][month] - e.g. sales[0][0] = Cozy, Month 1
public class Product implements IProduct {

    private int[][] sales; // 2D array: 3 products x 3 months
    private String[] productNames; // 1D array: product names

    // Constructor
    public Product(int[][] sales, String[] productNames) {
        this.sales = sales;
        this.productNames = productNames;
    }

    @Override
    public int GetTotalProductsSold() {
        int total = 0;
        for (int i = 0; i < sales.length; i++) {
            for (int j = 0; j < sales[i].length; j++) {
                total += sales[i][j];
            }
        }
        return total;
    }

    @Override
    public double GetAverageProductSold() {
        int total = GetTotalProductsSold();
        int count = sales.length * sales[0].length; // 3 x 3 = 9
        return (double) total / count;
    }

    // Helper: total per product
    public int getTotalForProduct(int productIndex) {
        int total = 0;
        for (int month = 0; month < sales[productIndex].length; month++) {
            total += sales[productIndex][month];
        }
        return total;
    }

    @Override
    public String GetMostPopularProduct() {
        int maxIndex = 0;
        int maxTotal = getTotalForProduct(0);
        for (int i = 1; i < sales.length; i++) {
            int currentTotal = getTotalForProduct(i);
            if (currentTotal > maxTotal) {
                maxTotal = currentTotal;
                maxIndex = i;
            }
        }
        // Spec says: based on highest TOTAL sales, so return total (e.g. 63)
        // Screenshot shows 25, which is highest single month - we follow spec.
        return productNames[maxIndex] + "(" + maxTotal + ")";
    }
    
    //Q.1.3 
    // PrintProduct - responsible ONLY for printing the report - Q1.3
public class PrintProduct {

    public void printTotalProductSales(int total) {
        System.out.println("TOTAL PRODUCT SALES: " + total);
    }

    public void printAverageProductSales(double average) {
        // Sample shows 17 (no decimal). Use Math.round to match sample
        System.out.println("AVERAGE PRODUCT SALES: " + Math.round(average));
    }

    public void printMostPopularProduct(String mostPopular) {
        System.out.println("MOST POPULAR PRODUCT: " + mostPopular);
    }

    public void printReport(Product product) {
        System.out.println("\nPRODUCT SALES REPORT - 2026");
        System.out.println("************************************");
        printTotalProductSales(product.GetTotalProductsSold());
        printAverageProductSales(product.GetAverageProductSold());
        printMostPopularProduct(product.GetMostPopularProduct());
    }
}

// Q1.4 - Unit tests for Product class
public class ProductTest {

    // Test data from sample: Cozy 25,18,20 / Restonic 15,10,12 / Sealy 18,15,20
    private Product createTestProduct() {
        String[] names = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        int[][] sales = {{25, 18, 20}, {15, 10, 12}, {18, 15, 20}};
        return new Product(sales, names);
    }

    @Test
    public void GetTotalProductSales_WithValidData_ReturnsCorrectValue() {
        Product product = createTestProduct();
        assertEquals(153, product.GetTotalProductsSold());
    }

    @Test
    public void GetAverageSales_WithValidData_ReturnsProductSold() {
        Product product = createTestProduct();
        // 153 / 9 = 17.0
        assertEquals(17.0, product.GetAverageProductSold(), 0.01);
    }
}

