package year2017.day6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Part1 {

	public static void main(String[] args) {
		int[] input = new int[] { 0, 5, 10, 0, 11, 14, 13, 4, 11, 8, 8, 7, 1, 4, 12, 11 };
		Set<State> seen = new HashSet<>();
		int counter = 0;
		seen.add(new State(input));
		for (;;) {
			counter++;
			int index = maxIndex(input);
			int blocks = input[index];
			input[index] = 0;
			for (int i = 0; i < blocks; i++) {
				index++;
				if (index == input.length) {
					index = 0;
				}
				input[index]++;
			}
			if (!seen.add(new State(input))) {
				System.out.println(counter);
				return;
			}
		}

	}

	static int maxIndex(int[] banks) {
		int max = Integer.MIN_VALUE, index = Integer.MIN_VALUE;
		for (int i = 0; i < banks.length; i++) {
			if (banks[i] > max) {
				max = banks[i];
				index = i;
			}
		}
		return index;
	}

	static class State {
		
		final int[] banks;

		public State(int[] banks) {
			this.banks = Arrays.copyOf(banks, banks.length);
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + Arrays.hashCode(banks);
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			State other = (State) obj;
			if (!Arrays.equals(banks, other.banks))
				return false;
			return true;
		}

	}

}
