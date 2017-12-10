package year2017.day10;

public class Part1 {
	public static void main(String[] args) {
		int hash = knotHash(256, new int[] { 70, 66, 255, 2, 48, 0, 54, 48, 80, 141, 244, 254, 160, 108, 1, 41 });
		System.out.println(hash);
	}

	static int knotHash(int length, int[] lengths) {
		int[] values = start(length);
		int current = 0, skip = 0;
		for (int l : lengths) {
			reverse(current, l, values);
			current += l;
			current += skip;
			skip++;
		}
		return values[0] * values[1];
	}

	static void reverse(int start, int length, int[] values) {
		if (length > values.length) {
			throw new IllegalStateException(length + " > " + values.length);
		}

		for (int i = 0; i < length / 2; i++) {
			int k = start + i;
			while (k >= values.length) {
				k -= values.length;
			}

			int m = start + length - 1 - i;
			while (m >= values.length) {
				m -= values.length;
			}

			int tmp = values[k];
			values[k] = values[m];
			values[m] = tmp;
		}

	}

	static int[] start(int size) {
		int[] result = new int[size];
		for (int i = 0; i < result.length; i++) {
			result[i] = i;
		}
		return result;
	}

}
