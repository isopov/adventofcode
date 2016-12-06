package year2015.day14;

public class Reindeer {
    public final String name;
    public final int speed;
    public final int speedTime;
    public final int restTime;
    public int score = 0;

    public Reindeer(String name, int speed, int speedTime, int restTime) {
        this.name = name;
        this.speed = speed;
        this.speedTime = speedTime;
        this.restTime = restTime;
    }

    @Override
    public String toString() {
        return "Reindeer [name=" + name + ", speed=" + speed + ", speedTime=" + speedTime + ", restTime=" + restTime
                + "]";
    }

}