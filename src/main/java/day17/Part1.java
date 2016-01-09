package day17;

import java.util.List;
import java.util.Scanner;

import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.math.LongMath;

public class Part1 {
    public static void main(String[] args) {
        // Set<Set<Сontainer>> variants = new HashSet<>();
        int counter = 0;
        long variantsVisited = 0;
        List<Integer> data = getData();
        System.out.println(LongMath.factorial(data.size()));
        outer: for (List<Integer> possible : Collections2.permutations(data)) {
            long sum = 0;
            variantsVisited++;
            if (variantsVisited % 10000000000000L == 0L) {
                System.out.println(variantsVisited);
            }

            for (int i = 0; i < possible.size(); i++) {
                long container = possible.get(i);
                sum += container;
                if (sum == 150L) {
                    counter++;
                }
                if (sum >= 150L) {
                    continue outer;
                }
            }

        }
        System.out.println(counter);

    }

    public static List<Integer> getData() {
        ImmutableList.Builder<Integer> resultBuilder = ImmutableList.<Integer> builder();

        try (Scanner scanner = new Scanner(Part1.class.getResourceAsStream("day17-input"))) {
            while (scanner.hasNextLine()) {
                resultBuilder.add(Integer.parseInt(scanner.nextLine()));
            }
        }

        return resultBuilder.build();
    }
}
