// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,-3));   // 2 + 3
		System.out.println(plus(-2,-3));   // -5
		System.out.println(plus(-2,3));   // 1
	    System.out.println(minus(7,-2));  // 9
		System.out.println(minus(-7,2));  // -9
   		//System.out.println(minus(2,7));  // 2 - 7
 		//System.out.println(times(3,4));  // 12
		//System.out.println(times(2,4));  // 8
		//System.out.println(times(2,-4));  // -8
		//System.out.println(times(-2,4));  // -8
		//System.out.println(times(-2,-4));  // 8
   		//System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		//ystem.out.println(pow(5,3));      // 5^3
   		//System.out.println(pow(3,5));      // 3^5
		//System.out.println(pow(3,-5));      // 3^5
		//System.out.println(pow(-5,3));      // 5^3
   		//System.out.println(div(12,-3));   // 12 / 3    
   		//System.out.println(div(-5,5));    // 5 / 5  
		//System.out.println(div(10,3));    // 3
   		//System.out.println(div(25,7));   // 25 / 7
   		//System.out.println(mod(25,7));   // 25 % 7 = 4
   		//System.out.println(mod(120,6));  // 120 % 6 = 0  
   		//System.out.println(sqrt(36));
		//System.out.println(sqrt(263169));
   		//System.out.println(sqrt(76123));
		//System.out.println(sqrt(8));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int sum = x1;
		if (x2 < 0)
		{
			return minus(x1, -x2);
		}
		for (int i = 0; i < x2; i++){
			sum ++;
		}
		return sum;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int sum = x1;
		if (x2 < 0)
		{
			return plus(x1, -x2);
		}
		int y2 = Math.abs(x2);
		for (int i = 0; i < y2; i++){
			sum --;
		}
		return sum;	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		if (x1 == 0 || x2 == 0)
		{
			return 0;
		}
		int sum = Math.abs(x1);
		int y1 = Math.abs(x1);
		int y2 = Math.abs(x2);
		for (int i = 1; i < y2; i++){
			sum = plus(sum, y1);
		}
		if ((x2 > 0 && x1 > 0) || (x2 < 0 && x1 < 0))
		{
			return sum;
		}
		 else
		{
			return -sum;
		}
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		// For n < 0
		/*if (n < 0)
		{
			return div(1, pow(x, Math.abs(n)));	
		}*/
		int sum = x;
		if (n == 0)
		{
			return 1;
		}
		if (n > 0) {
			for (int i = 1; i < n; i++)
			{
				sum = times(sum, x);
			}
		}
		return sum;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int counter = 0;
		int y1 = Math.abs(x1), y2 = Math.abs(x2);
		for (counter = 0;y1 >= y2; counter++) 
		{
			y1 = minus(y1, y2);
		}
		if ((x1 < 0 && x2 < 0) || (x1 > 0 && x2 > 0))
		{
			return counter;
		} else 
		{
			return -counter;
		}
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int sum = x1;
		while ((sum - x2) >= 0) {
			sum = minus(sum, x2);
		}
		return sum;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int counter = 1;
		if (counter == 0)
		{
			return 0;
		} else
		{
			while (times(counter, counter) <= x)
			{
				counter ++;
			}
		}
		//for (counter = 1;(counter != div(x, counter)) && (counter < div(x, counter)); counter++){}
		return (int)minus(counter, 1);
	}	  	  
}