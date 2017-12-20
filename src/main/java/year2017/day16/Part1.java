package year2017.day16;

import java.util.Scanner;

public class Part1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(Part1.class.getResourceAsStream("input"));
		String input = scanner.next();
		System.out.println(dance(16, input));
	}

	static void dance(char[] programs, String input) {
		for (String move : input.split(",")) {
			switch (move.charAt(0)) {
			case 's':
				rotate(programs, Integer.valueOf(move.substring(1)));
				break;
			case 'x': {
				String[] split = move.substring(1).split("/");
				int a = Integer.valueOf(split[0]);
				int b = Integer.valueOf(split[1]);
				char temp = programs[a];
				programs[a] = programs[b];
				programs[b] = temp;
				break;
			}
			case 'p': {
				String[] split = move.substring(1).split("/");
				swap(programs, split[0].charAt(0), split[1].charAt(0));
				break;
			}
			default:
				throw new IllegalStateException("Unknown move " + move);
			}

		}
	}

	static String dance(int programs, String input) {
		char[] result = programs(programs);
		dance(result, input);
		return new String(result);
	}

	static void swap(char[] chars, char a, char b) {
		int swapped = 0;
		for (int i = 0; i < chars.length || swapped < 2; i++) {
			if (chars[i] == a) {
				chars[i] = b;
				swapped++;
			} else if (chars[i] == b) {
				chars[i] = a;
				swapped++;
			}
		}
	}

	static void rotate(char[] arr, int order) {
		if (order > arr.length) {
			order = order % arr.length;
		}

		int a = arr.length - order;
		reverse(arr, 0, a - 1);
		reverse(arr, a, arr.length - 1);
		reverse(arr, 0, arr.length - 1);
	}

	static void reverse(char[] arr, int left, int right) {
		while (left < right) {
			char temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
	}

	static char[] programs(int programs) {
		char[] result = new char[programs];
		for (int i = 0; i < result.length; i++) {
			result[i] = (char) ('a' + i);
		}
		return result;
	}

}
