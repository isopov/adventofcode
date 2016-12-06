package day20;

import java.util.stream.LongStream;

public class Part1 {
	private static final int INPUT = 29_000_000;

	public static void main(String[] args) {
		for (int i = 600_000; i < 1_000_000; i++) {
			if (i % 1_000 == 0) {
				System.out.println(i + " houses checked");
			}
			if (numberOfPresents(i) >= INPUT) {
				System.out.println(i);
				break;
			}
		}

		System.out.println("number for 999_000 - " + numberOfPresents(999_000));

	}

	private static long numberOfPresents(int houseNumber) {
		return LongStream.rangeClosed(1, houseNumber).parallel().filter(i -> houseNumber % i == 0).map(i -> i * 10)
				.sum();

	}

}
