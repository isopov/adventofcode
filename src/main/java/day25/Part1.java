package day25;

public class Part1 {
	public static void main(String[] args) {
		System.out.println(getCode(2981, 3075));
	}

	static final long getCode(int row, int column) {
		return getCode(getIndex(row, column));
	}

	static final long getCode(int index) {
		long result = 20151125L;
		for (int i = 1; i < index; i++) {
			result *= 252533L;
			result %= 33554393L;
		}
		return result;
	}

	static final int getIndex(int row, int column) {
		int index = 1, i = 1, j = 1;
		while (i != row || j != column) {
			index++;
			if (i == 1) {
				i = j + 1;
				j = 1;
			} else {
				i--;
				j++;
			}
		}
		return index;
	}

}
