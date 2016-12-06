package year2015.day10;

public class Part1 {

    public static void main(String[] args) {
        String str = "1113122113";
        for (int i = 0; i < 50; i++) {
            str = next(str);
        }
        System.out.println(str.length());
    }

    public static String next(String str) {
        StringBuilder result = new StringBuilder();

        char prev = str.charAt(0);
        int size = 1;
        for (int i = 1; i < str.length(); i++) {
            char current = str.charAt(i);
            if (current == prev) {
                size++;
            } else {
                result.append(size).append(prev);
                prev = current;
                size = 1;
            }
        }
        result.append(size).append(prev);
        return result.toString();
    }

}
