package year2015.day16;

import static java.lang.Integer.parseInt;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableMap;

public class Part1 {

    // children: 3
    // cats: 7
    // samoyeds: 2
    // pomeranians: 3
    // akitas: 0
    // vizslas: 0
    // goldfish: 5
    // trees: 3
    // cars: 2
    // perfumes: 1

    public static void main(String[] args) {
        List<Sue> aunts = getData().stream()
                .filter(filtering("children", 3))
                .filter(filtering("cats", 7))
                .filter(filtering("samoyeds", 2))
                .filter(filtering("pomeranians", 3))
                .filter(filtering("akitas", 0))
                .filter(filtering("vizslas", 0))
                .filter(filtering("goldfish", 5))
                .filter(filtering("trees", 3))
                .filter(filtering("cars", 2))
                .filter(filtering("perfumes", 1))
                .collect(Collectors.toList());

        System.out.println(aunts);

    }

    private static Predicate<Sue> filtering(String property, int value) {
        return (Sue sue) -> sue.properties.get(property) == null
                || sue.properties.get(property) == value;

    }

    public static List<Sue> getData() {
        List<Sue> data = new ArrayList<>();
        try (Scanner scanner = new Scanner(Part1.class.getResourceAsStream("day16-input"))) {
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split("[ ,:]");

                Map<String, Integer> properties = ImmutableMap.<String, Integer> builder()
                        .put(line[3], parseInt(line[5]))
                        .put(line[7], parseInt(line[9]))
                        .put(line[11], parseInt(line[13]))
                        .build();

                data.add(new Sue(parseInt(line[1]), properties));

            }
        }
        return data;
    }

}
