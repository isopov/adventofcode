package year2016.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;



public class Part1 {

	public static void main(String[] args) throws IOException {
		
		System.out.println(code(lines(Part1.class.getResourceAsStream("input"))));
	}
	
	public static List<String> lines(InputStream input) throws IOException {
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(input))) {
            return buffer.lines().collect(Collectors.toList());
        }
    }
	

	public static String code(List<String> input) {
		StringBuilder result = new StringBuilder();
		Player player = new Player();
		for (String line : input) {
			player.move(line);
			result.append(player.state);
		}
		return result.toString();
	}

	private static final class Player {
		private int state = 5;

		public void move(String line) {
			for (int i = 0; i < line.length(); i++) {
				move(line.charAt(i));
			}
		}

		public void move(char direction) {
			switch (direction) {
			case 'U':
				up();
				break;
			case 'L':
				left();
				break;
			case 'R':
				right();
				break;
			case 'D':
				down();
				break;
			default:
				throw new IllegalArgumentException();
			}
		}

		private void up() {
			if (state > 3) {
				state -= 3;
			}
		}

		private void down() {
			if (state < 7) {
				state += 3;
			}
		}

		private void right() {
			if (state != 3 && state != 6 && state != 9) {
				state++;
			}
		}

		private void left() {
			if (state != 1 && state != 4 && state != 7) {
				state--;
			}
		}

	}

}
