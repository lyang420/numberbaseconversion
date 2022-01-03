import java.util.ArrayList;
import java.util.Scanner;

/* Implement functionality to convert between any two given bases? */

public class NumberBaseConverter {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int integerBefore, base;
		
		/* What if the user does not input an integer? */
		
		System.out.print("Give me an integer to convert: ");
		integerBefore = sc.nextInt();
		
		System.out.print("What base is this integer in? ");
		base = sc.nextInt();
		
		/* Implement loop so that it keeps asking for values
		   and performing conversions until the user tells
		   it to stop. */
		
		convert(integerBefore, base);
		
		sc.close();
	}
	
	public static void convert(int integerToConvert, int givenBase) {
		int integerBefore = integerToConvert, idx = 0, ans = 0;
		
		if (integerToConvert == 0) {
			System.out.println(integerBefore + " in base 10 is 0.");
		} else {
			ArrayList<Integer> parsedInt = new ArrayList<Integer>();
			while (integerBefore != 0) {
				parsedInt.add(integerBefore % 10);
				integerBefore /= 10;
			}
			
			/* More efficient way to do this? */
			
			ArrayList<Integer> convertedInt = new ArrayList<Integer>();
			for (int i : parsedInt) {
				convertedInt.add((int) (i * (Math.pow(givenBase, idx))));
				idx++;
			}
			
			for (int i : convertedInt) {
				ans += i;
			}
			
			System.out.println(integerToConvert + " in base 10 is " + ans + ".");
		}
	}

}
