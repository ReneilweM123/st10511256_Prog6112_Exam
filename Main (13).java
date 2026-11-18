/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		
		//Q.2.5
		public interface IproductCalculations {
		    double GetVat();
		    double GetCommission();
		    double GetTotal();
		}
		public class IproductCalculations
		implements IproductCalculations {
		    private double price;
		    
		    public ProductCalculations(double price) {
		        this.price = price;
		    }
		    @Override
		    public double GetVat() {
		        return price * 0.15; // 15% GetVat
		    }
		    
		    @Override
		    public double GetCommission() {
		        return price * 0.05; // 5% GetCommission
		    }
		    
		    @Override
		    public double GetTotal() {
		        return price + GetVat() + GetCommission(); // Price + VAT + GetCommission
		    }
		}
		
		//Q.2.6 
		
		public class ProductCalculationsTest {
		    @Test 
		    public void 
		    GetVat_WithValidData_ReturnsCorrectValue() {
		        ProductCalculations calc = new ProductCalculations (3500);
		        assertEquals(525.0, calc.GetVat(), 0.01);
		    }
		    
		    @Test 
		    public void
		    GetTotal_WithValidData_ReturnsCorrectValue() {
		        ProductCalculatons calc = new ProductCalculations(3500);
		        // 3500 + 525 + 175 = 4200 assertEquals (4200.0, calc.GetTotal(), 0.01);
		    }
		    }
		        
		    }
		        
		    }
		}
		    }
		    
		    }
		    }
		    }
		}
	}
}