package day14;

import java.util.ArrayList;
import java.util.List;

public class Part2 {
    public static void main(String[] args) {
        List<Reindeer> reindeers = Part1.getData();

        int leadDistance = 0;
        List<Reindeer> leads = new ArrayList<>();
        for (int i = 1; i <= 2503; i++) {
            for (Reindeer reindeer : reindeers) {
                int curentDist = Part1.result(reindeer, i);
                if (curentDist > leadDistance) {
                    leads.clear();
                    leadDistance = curentDist;
                    leads.add(reindeer);
                } else if (curentDist == leadDistance) {
                    leads.add(reindeer);
                }
            }
            for (Reindeer lead : leads) {
                lead.score++;
            }
            leads.clear();
        }

        for (Reindeer reindeer : reindeers) {
            System.out.println(reindeer.name + " " + reindeer.score);
        }

    }
}
