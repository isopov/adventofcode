package year2015.day13;

import static year2015.day13.Part1.pair;

public class Part2 {
    public static void main(String[] args) {
        Data data = Part1.getData();

        for (String other : data.people) {
            data.haps.put(pair("Myself", other), 0);
        }
        data.people.add("Myself");

        System.out.println(Part1.getMaxHappiness(data));

    }
}
