package year2017.day13;

import org.eclipse.collections.api.map.primitive.MutableIntObjectMap;
import org.eclipse.collections.impl.map.mutable.primitive.IntObjectHashMap;

public class Part1 {

	public static void main(String[] args) {
		int severity = severity(new String[] {
				"0: 3", "1: 2", "2: 4", "4: 4", "6: 5", "8: 8", "10: 6", "12: 6", "14: 6", "16: 6", "18: 8", "20: 8",
				"22: 12", "24: 10", "26: 9", "28: 8", "30: 8", "32: 12", "34: 12", "36: 12", "38: 12", "40: 8",
				"42: 12", "44: 14", "46: 14", "48: 10", "50: 12", "52: 12", "54: 14", "56: 14", "58: 14", "62: 12",
				"64: 14", "66: 14", "68: 14", "70: 12", "74: 14", "76: 14", "78: 14", "80: 18", "82: 17", "84: 30",
				"88: 14"
		});
		System.out.println(severity);
	}

	static int severity(String[] inputs) {

		MutableIntObjectMap<Layer> layers = new IntObjectHashMap<>();
		for (String input : inputs) {
			String[] split = input.split(": ");
			int layer = Integer.valueOf(split[0]);
			int depth = Integer.valueOf(split[1]);
			layers.put(layer, new Layer(depth));
		}

		Layer[] wall = new Layer[layers.keySet().max() + 1];
		for (int i = 0; i < wall.length; i++) {
			wall[i] = layers.get(i);
		}

		int result = 0;
		for (int range = 0; range < wall.length; range++) {
			Layer layer = wall[range];
			if (layer != null) {
				if (layer.current == 0) {
					result += range * layer.depth;
				}
			}
			tick(wall);
		}
		return result;
	}

	static void tick(Layer[] wall) {
		for (Layer layer : wall) {
			if (layer != null) {
				layer.tick();
			}
		}
	}

	static class Layer {
		final int depth;
		int current = 0;
		boolean up = true;

		Layer(int depth) {
			this.depth = depth;
		}

		void tick() {
			if (up) {
				current++;
				if (current == depth - 1) {
					up = false;
				}
			} else {
				current--;
				if (current == 0) {
					up = true;
				}
			}
		}
	}

}
