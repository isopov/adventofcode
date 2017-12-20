package year2017.day15;

public class Part1 {

	public static void main(String[] args) {
		System.out.println(judge(277, 349, 40_000_000));
	}

	static int judge(int a, int b, int count) {
		int result = 0;
		for (int i = 0; i < count; i++) {
			a = next(a, 16807L);
			b = next(b, 48271L);
			if (compare(a, b)) {
				result++;
			}
		}
		return result;
	}

	static int next(int prev, long factor) {
		long result = prev;
		result *= factor;
		return (int) (result % 2147483647L);
	}

	static boolean compare(int a, int b) {
		a = a & ((1 << 16) - 1);
		b = b & ((1 << 16) - 1);
		return a == b;
	}

}
