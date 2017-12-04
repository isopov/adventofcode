package year2017.day1;

public class Part2 {

	public static void main(String... args) {
		System.out.println(sum(Part1.INPUT));
	}

	public static int sum(String line) {
		int result = 0;
		char[] charArray = line.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] == charArray[otherIndex(i, charArray.length)]) {
				result += Integer.valueOf(String.valueOf(charArray[i]));
			}
		}
		return result;
	}

	private static int otherIndex(int i, int length) {
		int result = i + length /2;
		if(result >= length) {
			result -= length;
		}
		return result;
	}

}
