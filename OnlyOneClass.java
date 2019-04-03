import java.util.InputMismatchException;
import java.util.Scanner;

//B1 Teodor Dobrev 121217100 38th group

public class OnlyOneClass {
	public static void main(String[] args) throws InputMismatchException, Exception {

		// Getting the number from the user
		Scanner scan = new Scanner(System.in);
		int n = 0;
		while (n < 2) {
			System.out.print("Please enter a number (>1) : ");
			try {
				n = scan.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("It has to be an integer".toUpperCase());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				scan.nextLine();
			}

			if (n < 2) {
				System.out.println("Bigger than 1, please!");
			}
		}

		// Creating a boolean array (true for prime numbers; false for non-primes)
		boolean[] arr = new boolean[n + 1];
		for (int i = 2; i <= n; i++) {
			arr[i] = true;
		}

		// Sieve of Eratosthenes algorithm marks prime numbers
		for (int i = 2; i * i <= n; i++) {
			if (arr[i]) { // if (true)
				for (int j = i; i * j <= n; j++) {
					arr[i * j] = false;
				}
			}
		}

		// Writing all the numbers
		System.out.println("Numbers are: ");
		System.out.println(" 1");
		for (int i = 2; i <= n; i++) {
			if (arr[i]) {
				System.out.println(" " + i);
			} else {
				
				System.out.print(" " + i + " {");

				for (int j = 1; j <= i; j++) {
					if (i % j == 0) {
						if (arr[j]) {
							System.out.print(" " + j);
						}	
					}
				}

				System.out.print("}");
				System.out.println();
			}

		}
		
		scan.close();

	}
}
