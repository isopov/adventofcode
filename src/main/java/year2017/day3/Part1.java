package year2017.day3;

public class Part1 {
	public static void main(String[] args) {
		System.out.println(dist(361527));
	}

	public static int dist(int square) {
		final int[] coords = coords(square);
		return Math.abs(coords[0]) + Math.abs(coords[1]);

	}

	static int[] coords(int square) {
		final int[] coords = { 0, 0 };
		State state = State.RIGHT;
		int steps = 1;
		int stepsDone = 0;
		for (int i = 1; i < square; i++) {
			state.doStep(coords);
			stepsDone++;
			if (stepsDone == steps) {
				state = state.next();
				stepsDone = 0;
				steps = state.nextSteps(steps);
			}
		}
		return coords;
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
