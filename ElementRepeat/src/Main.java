import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> integers = new ArrayList<>
                (Arrays.asList(4,5,6,4,5,3,4,2,4,5,7));

        Map<Integer, Integer> repeats = new TreeMap<>();

        long t1 = System.currentTimeMillis();

        for (Integer i : integers) {
            if (repeats.containsKey(i)) {
                repeats.put(i, repeats.get(i) + 1);
            } else {
                repeats.put(i, 1);
            }
        }
        long t2 = System.currentTimeMillis();
        System.out.println("Time work: " + (t2 - t1));

        System.out.println("Result: ");
        for (Map.Entry<Integer, Integer>  entry : repeats.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
