package year2017.day20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import year2017.day20.Part1.Particle;
import year2017.day20.Part1.Vec;

public class Part2 {

	public static void main(String[] args) {
		System.out.println(noCollisions(Part1.getInput()));
	}

	static int noCollisions(List<String> input) {
		List<Particle> particles = Part1.getParticles(input);

		for (int i = 0; i < 300; i++) {
			Map<Vec, Particle> map = new HashMap<>();
			List<Vec> forRemove = new ArrayList<>();
			for (Particle p : particles) {
				p.step();
				if (map.containsKey(p.getP())) {
					forRemove.add(p.getP());
				} else {
					map.put(p.getP(), p);
				}
			}
			map.keySet().removeAll(forRemove);
			particles = new ArrayList<>(map.values());
		}

		return particles.size();
	}

}
