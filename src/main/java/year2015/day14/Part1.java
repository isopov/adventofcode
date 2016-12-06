package year2015.day14;

import static java.lang.Integer.parseInt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part1 {
    public static void main(String[] args) {
        List<Reindeer> reindeers = getData();

        for (Reindeer reindeer : reindeers) {
            System.out.println(reindeer.name + " " + result(reindeer, 2503));
        }
    }

    public static List<Reindeer> getData() {
        List<Reindeer> reindeers = new ArrayList<>();
        try (Scanner scanner = new Scanner(Part1.class.getResourceAsStream("day14-input"))) {
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(" ");
                reindeers.add(new Reindeer(line[0], parseInt(line[3]), parseInt(line[6]), parseInt(line[13])));
            }
        }
        return reindeers;
    }

    public static int result(Reindeer reindeer, int time) {
        int result = 0;
        boolean resting = false;

        int restingTime = 0;
        int speedTime = 0;

        for (int i = 0; i < time; i++) {
            if (resting) {
                restingTime++;
                if (restingTime >= reindeer.restTime) {
                    resting = false;
                    restingTime = 0;
                }

            } else {
                speedTime++;
                result += reindeer.speed;
                if (speedTime >= reindeer.speedTime) {
                    resting = true;
                    speedTime = 0;
                }
            }

        }
        return result;
    }

}
