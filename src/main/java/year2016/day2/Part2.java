package year2016.day2;

import static year2016.day2.Part1.lines;

import java.io.IOException;
import java.util.List;

public class Part2 {

	public static void main(String[] args) throws IOException {

		System.out.println(code(lines(Part1.class.getResourceAsStream("input"))));
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

	public static final class Player {
		public char state = '5';

		public Player() {
		}

		public Player(char state) {
			this.state = state;
		}

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
			switch (state) {
			case '3':
				state='1';
				break;
			case '6':
				state='2';
				break;
			case '7':
				state='3';
				break;
			case '8':
				state='4';
				break;
			case 'A':
				state='6';
				break;
			case 'B':
				state='7';
				break;
			case 'C':
				state='8';
				break;
			case 'D':
				state='B';
				break;
			}

		}


		
		private void down() {
			switch (state) {
			case '1':
				state='3';
				break;
			case '2':
				state='6';
				break;
			case '3':
				state='7';
				break;
			case '4':
				state='8';
				break;
			case '6':
				state='A';
				break;
			case '7':
				state='B';
				break;
			case '8':
				state='C';
				break;
			case 'B':
				state='D';
				break;
			}
		}
		
		private void right() {
			switch (state) {
			case '5':
				state='6';
				break;
			case '2':
				state='3';
				break;
			case '6':
				state='7';
				break;
			case 'A':
				state='B';
				break;
			case '3':
				state='4';
				break;
			case '7':
				state='8';
				break;
			case 'B':
				state='C';
				break;
			case '8':
				state='9';
				break;
			}
		}

		private void left() {
			switch (state) {
			case '9':
				state='8';
				break;
			case '4':
				state='3';
				break;
			case '8':
				state='7';
				break;
			case 'C':
				state='B';
				break;
			case '3':
				state='2';
				break;
			case '7':
				state='6';
				break;
			case 'B':
				state='A';
				break;
			case '6':
				state='5';
				break;
			}
		}

	}

}
