package year2015.day9;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableSet;

public class Part1 {
    public static void main(String[] args) {

        Map<Set<String>, Integer> distances = new HashMap<>();
        Set<String> cities = new HashSet<>();

        try (Scanner scanner = new Scanner(Part1.class.getResourceAsStream("day9-input"))) {
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(" = ");
                String[] lineCities = line[0].split(" to ");
                cities.add(lineCities[0]);
                cities.add(lineCities[1]);

                distances.put(ImmutableSet.<String> builder().add(lineCities[0], lineCities[1]).build(),
                        Integer.valueOf(line[1]));

            }
        }

        long result = 0;
        for (List<String> permutation : Collections2.permutations(cities)) {
            long current = 0L;
            String prev = null;
            for (String city : permutation) {
                if (prev == null) {
                    prev = city;
                    continue;
                }
                int dist = distances.get(ImmutableSet.<String> builder().add(prev, city).build());
                current += dist;
                prev = city;
            }
            result = Math.max(current, result);
        }

        System.out.println(result);

    }

}
