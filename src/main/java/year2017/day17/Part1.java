package year2017.day17;

import java.util.ArrayList;
import java.util.List;

public class Part1 {

	public static void main(String[] args) {
		System.out.println(after(359, 2017));
	}

	static int after(int steps, int times) {
		List<Integer> buffer = new ArrayList<>(2018);
		buffer.add(0);
		buffer.add(1);
		int position = 1;
		for (int i = 2; i <= times; i++) {
			position += steps % buffer.size();
			position++;
			position = position % buffer.size();
			buffer.add(position, i);

		}
		return buffer.get(position + 1);
	}

}
