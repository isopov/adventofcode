package year2016.day1;

import java.util.HashSet;
import java.util.Set;

import com.google.common.base.Splitter;

import year2016.day1.Part1.Direction;

public class Part2 {

	public static void main(String[] args) {
		System.out.println(distance(Part1.INPUT));
	}
	public static int distance(String input) {
		Player player = new Player();
		Point result = null;
		for (String instruction : Splitter.on(", ").split(input)) {
			if ('L' == instruction.charAt(0)) {
				player.left();
			} else {
				player.right();
			}
			result = player.move(Integer.valueOf(instruction.substring(1)));
			if(result != null) break;
		}
		return result.vectorLength();
	}
	
	
	public static class Player {
		public Direction direction = Direction.UP;
		private int x, y;
		private Set<Point> points = new HashSet<>();

		public void left() {
			direction = direction.left();
		}

		public void right() {
			direction = direction.right();
		}

		public Point move(int distance) {
			for (int i = 0; i < distance; i++) {
				Point result = step();
				if (result != null) {
					return result;
				}
			}
			return null;
		}

		public Point step() {
			switch (direction) {
			case UP:
				y++;
				break;
			case DOWN:
				y--;
				break;
			case LEFT:
				x--;
				break;
			case RIGHT:
				x++;
				break;
			}
			Point currentPoint = new Point(x, y);
			if (!points.add(currentPoint)) {
				return currentPoint;
			}
			return null;
		}

	}

	private static class Point {
		private final int x, y;

		public int vectorLength() {
			return Math.abs(x) + Math.abs(y);
		}

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
	}

}
