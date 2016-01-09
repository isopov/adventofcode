package day15;

import static java.lang.Integer.parseInt;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Part1 {
    public static void main(String[] args) {
        Map<String, Ingridient> data = getData();
        System.out.println(data);
        long result = Long.MIN_VALUE;

        // this.capacity = capacity;
        // this.durability = durability;
        // this.flavor = flavor;
        // this.texture = texture;

        Ingridient sugarPars = data.get("Sugar");
        Ingridient sprinklesPars = data.get("Sprinkles");
        Ingridient candyPars = data.get("Candy");
        Ingridient chocolatePars = data.get("Chocolate");

        int sugarResult = 0, sprinklesResult = 0, candyResult = 0, chocolateResult = 0;
        for (int sugar = 0; sugar <= 100; sugar++) {
            for (int sprinkles = 0; sprinkles <= (100 - sugar); sprinkles++) {
                for (int candy = 0; candy <= (100 - sugar - sprinkles); candy++) {
                    for (int chocolate = 0; chocolate <= (100 - candy - sugar - sprinkles); chocolate++) {
                        int capacity = sugar * sugarPars.capacity
                                + sprinkles * sprinklesPars.capacity
                                + candy * candyPars.capacity
                                + chocolate * chocolatePars.capacity;

                        int durability = sugar * sugarPars.durability
                                + sprinkles * sprinklesPars.durability
                                + candy * candyPars.durability
                                + chocolate * chocolatePars.durability;

                        int flavor = sugar * sugarPars.flavor
                                + sprinkles * sprinklesPars.flavor
                                + candy * candyPars.flavor
                                + chocolate * chocolatePars.flavor;

                        int texture = sugar * sugarPars.texture
                                + sprinkles * sprinklesPars.texture
                                + candy * candyPars.texture
                                + chocolate * chocolatePars.texture;

                        int calories = sugar * sugarPars.calories
                                + sprinkles * sprinklesPars.calories
                                + candy * candyPars.calories
                                + chocolate * chocolatePars.calories;

                        if (calories == 500 && capacity > 0 && durability > 0 && flavor > 0 && texture > 0) {
                            long current = capacity * durability * flavor * texture;
                            if (current > result) {
                                sugarResult = sugar;
                                sprinklesResult = sprinkles;
                                candyResult = candy;
                                chocolateResult = chocolate;
                                result = current;
                            }
                        }
                    }
                }
            }
        }

        System.out.println("result - " + result);
        System.out.println("sugar - " + sugarResult);
        System.out.println("sprinkles - " + sprinklesResult);
        System.out.println("candy - " + candyResult);
        System.out.println("chocolate - " + chocolateResult);

    }

    public static Map<String, Ingridient> getData() {
        Map<String, Ingridient> data = new HashMap<>();
        try (Scanner scanner = new Scanner(Part1.class.getResourceAsStream("day15-input"))) {
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split("[ ,:]");
                System.out.println(Arrays.toString(line));
                data.put(line[0],
                        (new Ingridient(line[0], parseInt(line[3]),
                                parseInt(line[6]), parseInt(line[9]),
                                parseInt(line[12]), parseInt(line[15]))));
            }
        }
        return data;
    }

}
