package year2017.day3;

import java.util.HashMap;
import java.util.Map;

public class Part2 {
	public static void main(String[] args) {
		System.out.println(foo(361527));
	}

	static int foo(int input) {
		final int[] coords = { 0, 0 };
		State state = State.RIGHT;
		Map<Point, Integer> values = new HashMap<>();
		int steps = 1;
		int stepsDone = 0;
		values.put(new Point(coords[0], coords[1]), 1);
		for (;;) {
			state.doStep(coords);
			stepsDone++;
			if (stepsDone == steps) {
				state = state.next();
				stepsDone = 0;
				steps = state.nextSteps(steps);
			}
			int value = nullSafeUnbox(values.get(new Point(coords[0] - 1, coords[1])))
					+ nullSafeUnbox(values.get(new Point(coords[0] - 1, coords[1] - 1)))
					+ nullSafeUnbox(values.get(new Point(coords[0], coords[1] - 1)))

					+ nullSafeUnbox(values.get(new Point(coords[0] + 1, coords[1])))
					+ nullSafeUnbox(values.get(new Point(coords[0], coords[1] + 1)))
					+ nullSafeUnbox(values.get(new Point(coords[0] + 1, coords[1] + 1)))

					+ nullSafeUnbox(values.get(new Point(coords[0] - 1, coords[1] + 1)))
					+ nullSafeUnbox(values.get(new Point(coords[0] + 1, coords[1] - 1)));
			if (value > input) {
				return value;
			}
			values.put(new Point(coords[0], coords[1]), value);
		}
	}

	static int nullSafeUnbox(Integer val) {
		return val == null ? 0 : val;
	}

	static class Point {
		private final int x, y;

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

	enum State {
		RIGHT {
			@Override
			State next() {
				return UP;
			}

			@Override
			int nextSteps(int prev) {
				return prev + 1;
			}

			@Override
			void doStep(int[] coords) {
				coords[0]++;
			}
		},
		UP {
			@Override
			State next() {
				return LEFT;
			}

			@Override
			int nextSteps(int prev) {
				return prev;
			}

			@Override
			void doStep(int[] coords) {
				coords[1]++;

			}
		},
		LEFT {
			@Override
			State next() {
				return DOWN;
			}

			@Override
			int nextSteps(int prev) {
				return prev + 1;
			}

			@Override
			void doStep(int[] coords) {
				coords[0]--;

			}
		},
		DOWN {
			@Override
			State next() {
				return RIGHT;
			}

			@Override
			int nextSteps(int prev) {
				return prev;
			}

			@Override
			void doStep(int[] coords) {
				coords[1]--;
			}

		};

		abstract State next();

		abstract int nextSteps(int prev);

		abstract void doStep(int[] coords);
	}

}
