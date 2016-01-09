package day13;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableSet;

public class Part1 {
    public static void main(String[] args) {
        System.out.println(getMaxHappiness(getData()));
    }

    public static int getMaxHappiness(Data data) {
        int result = Integer.MIN_VALUE;

        int size = data.people.size();
        for (List<String> vars : Collections2.permutations(data.people)) {

            int current = data.haps.get(pair(vars.get(0), vars.get(size - 1)));
            String curPers = null;
            for (String pers : vars) {
                if (curPers == null) {
                    curPers = pers;
                    continue;
                }
                Integer next = data.haps.get(pair(curPers, pers));
                if (next == null) {
                    System.out.println(pair(curPers, pers));
                }
                current += next;
                curPers = pers;
            }
            if (current > result) {
                result = current;
            }

        }

        return result;
    }

    public static Data getData() {
        Data data = new Data();

        try (Scanner scanner = new Scanner(Part1.class.getResourceAsStream("day13-input"))) {
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(" happiness units by sitting next to ");
                String[] person = line[0].split(" ");
                String second = line[1].substring(0, line[1].length() - 1);
                Set<String> pair = ImmutableSet.<String> builder().add(second, person[0]).build();
                data.people.addAll(pair);

                int val = Integer.valueOf(person[3]);
                if ("lose".equals(person[2])) {
                    val = -val;
                }

                Integer curVal = data.haps.get(pair);
                if (curVal == null) {
                    curVal = 0;
                }
                curVal += val;
                data.haps.put(pair, curVal);
            }
        }

        return data;
    }

    public static Set<String> pair(String first, String second) {
        return ImmutableSet.<String> builder().add(first, second).build();
    }

}
