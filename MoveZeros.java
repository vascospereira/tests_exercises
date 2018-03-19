package move.zeros;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MoveZeros {
	public static void main(String[] args) {
		List<Integer> numbers = Collections.unmodifiableList(Arrays.asList(0, 2, 0, 3, 0, 1, 2));
		System.out.println(moveZeros(numbers));
	}

	private static List<Integer> moveZeros(List<Integer> numbers) {
		List<Integer> movedZeros = new ArrayList<>();
		if (numbers.isEmpty())
			return numbers;
		int zeros = 0;
		for (int i = 0; i < numbers.size(); i++) {
			if (numbers.get(i) == 0)
				zeros++;
			else
				movedZeros.add(numbers.get(i));
		}
		for (int i = 0; i < zeros; i++)
			movedZeros.add(0);
		return movedZeros;
	}
}
