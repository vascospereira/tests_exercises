import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateArray {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		System.out.println(rotate(numbers, 4));
	}

	private static List<Integer> rotate(List<Integer> numbers, int n) {
		List<Integer> rotated = new ArrayList<>();
		int nRotations = n % numbers.size();
		for (int i = numbers.size() - nRotations; i < numbers.size(); i++) 
			rotated.add(numbers.get(i));
		for (int i = 0; i < numbers.size() - nRotations; i++) 
			rotated.add(numbers.get(i));
		return rotated;
	}
}
