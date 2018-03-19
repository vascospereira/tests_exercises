import java.util.Scanner;

public final class MaxConsecutiveZeros {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = 0;
		System.out.println("Number: ");
		if (scanner.hasNextInt()) num = scanner.nextInt();
		System.out.println(maxConsecutiveZeros(num));
		scanner.close();
	}

	private static int maxConsecutiveZeros(int num) {
		int count = 0;
		int maxCount = 0;
		while(num != 0){
			if((num & 1) == 0)
				count++;
			else count = 0;
			if(count > maxCount)
				maxCount = count;
			num >>= 1;	
		}
		return maxCount;
	}
	
}
