package year2016.day1;

import com.google.common.base.Splitter;

public class Part1 {

	public static final String INPUT = "L3, R1, L4, L1, L2, R4, L3, L3, R2,"
			+ " R3, L5, R1, R3, L4, L1, L2, R2, R1, L4, L4, R2,"
			+ " L5, R3, R2, R1, L1, L2, R2, R2, L1, L1, R2, R1,"
			+ " L3, L5, R4, L3, R3, R3, L5, L190, L4, R4, R51,"
			+ " L4, R5, R5, R2, L1, L3, R1, R4, L3, R1, R3, L5,"
			+ " L4, R2, R5, R2, L1, L5, L1, L1, R78, L3, R2, L3,"
			+ " R5, L2, R2, R4, L1, L4, R1, R185, R3, L4, L1, L1,"
			+ " L3, R4, L4, L1, R5, L5, L1, R5, L1, R2, L5, L2, R4,"
			+ " R3, L2, R3, R1, L3, L5, L4, R3, L2, L4, L5, L4, R1,"
			+ " L1, R5, L2, R4, R2, R3, L1, L1, L4, L3, R4, L3, L5,"
			+ " R2, L5, L1, L1, R2, R3, L5, L3, L2, L1, L4, R4, R4,"
			+ " L2, R3, R1, L2, R1, L2, L2, R3, R3, L1, R4, L5, L3,"
			+ " R4, R4, R1, L2, L5, L3, R1, R4, L2, R5, R4, R2, L5,"
			+ " L3, R4, R1, L1, R5, L3, R1, R5, L2, R1, L5, L2, R2,"
			+ " L2, L3, R3, R3, R1";

	public static void main(String[] args) {
		System.out.println(distance(INPUT));
	}

	public static int distance(String input) {
		Player player = new Player();
		for (String instruction : Splitter.on(", ").split(input)) {
			if ('L' == instruction.charAt(0)) {
				player.left();
			} else {
				player.right();
			}
			player.move(Integer.valueOf(instruction.substring(1)));
		}
		return player.distance();
	}

	private static class Player {
		private Direction direction = Direction.UP;
		protected int x, y;

		public void left() {
			direction = direction.left();
		}

		public void right() {
			direction = direction.right();
		}

		public int distance() {
			return Math.abs(x) + Math.abs(y);
		}

		public void move(int distance) {
			switch (direction) {
			case UP:
				y += distance;
				break;
			case DOWN:
				y -= distance;
				break;
			case LEFT:
				x -= distance;
				break;
			case RIGHT:
				x += distance;
				break;
			}
		}

	}

	public enum Direction {
		UP {
			@Override
			public Direction left() {
				return LEFT;
			}

			@Override
			public Direction right() {
				return RIGHT;
			}
		},
		DOWN {
			@Override
			public Direction left() {
				return RIGHT;
			}

			@Override
			public Direction right() {
				return LEFT;
			}
		},
		LEFT {
			@Override
			public Direction left() {
				return DOWN;
			}

			@Override
			public Direction right() {
				return UP;
			}
		},
		RIGHT {
			@Override
			public Direction left() {
				return UP;
			}

			@Override
			public Direction right() {
				return DOWN;
			}
		};

		public abstract Direction left();

		public abstract Direction right();
	}

}
