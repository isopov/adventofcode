package year2017.day19;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part1 {
	public static void main(String[] args) {
		System.out.println(walkInput().seen);
	}

	static Packet walkInput() {
		Scanner scanner = new Scanner(Part1.class.getResourceAsStream("input"));
		List<char[]> map = new ArrayList<>();
		while (scanner.hasNext()) {
			map.add(scanner.nextLine().toCharArray());
		}
		return walk(map.toArray(new char[0][]), 'Y');
	}

	static Packet walk(char[][] map, char last) {
		Packet packet = init(map[0]);

		while (packet.dir != Direction.STOP) {
			packet.next(map, last);
		}
		return packet;
	}

	static String myWay(char[][] map, char last) {
		Packet packet = init(map[0]);

		while (packet.dir != Direction.STOP) {
			packet.next(map, last);
		}

		System.out.println(packet.steps);
		return packet.seen.toString();
	}

	static Packet init(char[] firstLine) {
		for (int i = 0; i < firstLine.length; i++) {
			if (firstLine[i] == '|') {
				return new Packet(i);
			}
		}
		throw new IllegalStateException();
	}

	static class Packet {
		int x = 0, y;
		Direction dir = Direction.DOWN;
		StringBuilder seen = new StringBuilder();
		int steps = 1;

		public Packet(int y) {
			this.y = y;
		}

		public void next(char[][] map, char lastChar) {
			steps++;
			switch (dir) {
			case DOWN:
				x++;
				break;
			case UP:
				x--;
				break;
			case LEFT:
				y--;
				break;
			case RIGHT:
				y++;
				break;
			default:
				throw new IllegalStateException();
			}

			final char current = map[x][y];
			if (Character.isAlphabetic(current)) {
				seen.append(current);
				if (lastChar == current) {
					dir = Direction.STOP;
				}
			}
			if (current == '+') {
				switch (dir) {
				case DOWN:
				case UP:
					if (y - 1 >= 0
							&& (map[x][y - 1] == '-' || Character.isAlphabetic(map[x][y - 1]))) {
						dir = Direction.LEFT;
					} else if (y + 1 < map[x].length
							&& (map[x][y + 1] == '-' || Character.isAlphabetic(map[x][y + 1]))) {
						dir = Direction.RIGHT;
					} else {
						throw new IllegalStateException();
					}
					break;
				case LEFT:
				case RIGHT:
					if (x - 1 >= 0
							&& (map[x - 1][y] == '|' || Character.isAlphabetic(map[x - 1][y]))) {
						dir = Direction.UP;
					} else if (x + 1 < map.length
							&& (map[x + 1][y] == '|' || Character.isAlphabetic(map[x + 1][y]))) {
						dir = Direction.DOWN;
					} else {
						throw new IllegalStateException();
					}
					break;
				default:
					throw new IllegalStateException();
				}
			}

		}
	}

	enum Direction {
		UP, DOWN, LEFT, RIGHT, STOP;
	}

}
