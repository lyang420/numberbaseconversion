package programs;

import java.util.ArrayList;
import java.util.Scanner;

/* Number Base Converter is a simple program that asks users for two 
 * integers, one of which is used as the input and another the number base of
 * the input.
 * 
 * The program will perform mathematical calculations to convert the input
 * into base 10 (decimal base), the one most of us are familiar with.
 * 
 * The program will terminate when the user tells it to by typing in "exit"
 * or "quit." */

public class NumberBaseConverter {
	
	/* Inputs are provided by the user of the program. */
	
	private Scanner sc;
	
	public NumberBaseConverter() {
		this.sc = new Scanner(System.in);
	}
	
	public void initiate() {
		String input = "";
		boolean running = true;
		int base = 0;
		
		/* Program will continue running and performing calculations at 
		   request of user until user instructs it to stop. */
		
		while (running) {
			System.out.println("Enter an integer:");
			input = sc.next();
			
			if (input.equals("exit") || input.equals("quit")) {
				running = false;
			} else if (!isNumber(input)) {
				System.out.println("Invalid option; please enter an integer.");
			} else {
				System.out.println("What base is this integer in?");
				base = sc.nextInt();
				convert (Integer.valueOf(input), base);
			}
			
		}
		
		sc.close();
	}
	
	/* Determines whether a given input is a valid integer or not. */
	
	public boolean isNumber(String input) {
		int integerValue = 0;
		
		if (input == null || input.equals("") || integerValue != 0) {
			return false;
		}
		
		try {
			integerValue = Integer.parseInt(input);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	public int convert(int input, int base) {
		ArrayList<Integer> parsedInt = new ArrayList<Integer>(), converted = new ArrayList<Integer>();
		int before = input, idx = 0, ans = 0;
		
		if (input == 0) {
			System.out.println(before + " in base 10 is 0.");
		} else if (base == 10) {
			System.out.println(before + "in base 10 is " + before + ".");
		} else {
			while (before != 0) {
				parsedInt.add(before % 10);
				before /= 10;
			}
			
			for (int i : parsedInt) {
				converted.add((int) (i * (Math.pow(base, idx))));
				idx++;
			}
			
			for (int i : converted) {
				ans += i;
			}
			
			System.out.println(input + " in base 10 is " + ans + ".");
		}
		
		return ans;
	}

}
