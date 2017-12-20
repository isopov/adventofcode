package year2017.day17;

public class Part2 {

	public static void main(String[] args) {
		System.out.println(after0(359, 50_000_000));
	}

	static int after0(int steps, int times) {
		int zero = 0;
		int position = 1;
		int result = 2;
		int size = 2;
		for (int i = 2; i <= times; i++) {
			position += steps % size;
			position++;
			position = position % size;

			size++;

			if (position == zero + 1) {
				result = i;
			}
			if (position <= zero) {
				zero++;
			}
		}
		return result;
	}
}
