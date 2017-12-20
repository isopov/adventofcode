package year2017.day15;

public class Part2 {

	public static void main(String[] args) {
		System.out.println(judge(277, 349, 5_000_000));
	}

	static int judge(int a, int b, int count) {
		int result = 0;
		for (int i = 0; i < count; i++) {
			a = divNext(a, 16807L, 4);
			b = divNext(b, 48271L, 8);
			if (compare(a, b)) {
				result++;
			}
		}
		return result;
	}

	static int divNext(int prev, long factor, int div) {
		int result = next(prev, factor);
		while(result % div != 0) {
			result = next(result, factor);
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
