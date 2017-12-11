package year2017.day10;

public class Part2 {
	public static void main(String[] args) {
		String hash = knotHash("70,66,255,2,48,0,54,48,80,141,244,254,160,108,1,41");
		System.out.println(hash);
	}

	static String knotHash(String input) {
		int[] lengths = lengths(input);
		int[] values = Part1.start(256);

		int current = 0, skip = 0;
		for (int i = 0; i < 64; i++) {
			for (int l : lengths) {
				Part1.reverse(current, l, values);
				current += l;
				current += skip;
				skip++;
			}
		}

		int[] result = new int[16];
		for (int i = 0; i < 16; i++) {
			result[i] = xor(i * 16, 16, values);
		}

		return toHex(result);
	}

	static String toHex(int[] values) {
		StringBuilder result = new StringBuilder(values.length * 2);
		for (int val : values) {
			result.append(String.format("%02x", val));
		}
		return result.toString();
	}

	static int xor(int start, int length, int[] values) {
		int result = 0;
		for (int i = start; i < start + length; i++) {
			result ^= values[i];
		}
		return result;
	}

	static int[] lengths(String input) {
		final int size = input.length();
		final int[] result = new int[size + 5];
		for (int i = 0; i < size; i++) {
			result[i] = (int) input.charAt(i);
		}

		result[size] = 17;
		result[size + 1] = 31;
		result[size + 2] = 73;
		result[size + 3] = 47;
		result[size + 4] = 23;

		return result;
	}

}
