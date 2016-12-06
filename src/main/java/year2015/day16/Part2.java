package year2015.day16;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Part2 {

    // children: 3
    // cats > 7
    // samoyeds: 2
    // pomeranians < 3
    // akitas: 0
    // vizslas: 0
    // goldfish < 5
    // trees > 3
    // cars: 2
    // perfumes: 1

    public static void main(String[] args) {
        List<Sue> aunts = Part1.getData().stream()
                .filter(filtering("children", 3))
                .filter(filteringGreater("cats", 7))
                .filter(filtering("samoyeds", 2))
                .filter(filteringFewer("pomeranians", 3))
                .filter(filtering("akitas", 0))
                .filter(filtering("vizslas", 0))
                .filter(filteringFewer("goldfish", 5))
                .filter(filteringGreater("trees", 3))
                .filter(filtering("cars", 2))
                .filter(filtering("perfumes", 1))
                .collect(Collectors.toList());

        System.out.println(aunts);

    }

    private static Predicate<Sue> filtering(String property, int value) {
        return (Sue sue) -> sue.properties.get(property) == null
                || sue.properties.get(property) == value;

    }

    private static Predicate<Sue> filteringGreater(String property, int value) {
        return (Sue sue) -> sue.properties.get(property) == null
                || sue.properties.get(property) > value;

    }

    private static Predicate<Sue> filteringFewer(String property, int value) {
        return (Sue sue) -> sue.properties.get(property) == null
                || sue.properties.get(property) < value;

    }
}
