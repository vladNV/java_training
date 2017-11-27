import java.util.ArrayList;
import java.util.Random;

public class Main {

    private static int count;
    private static String msg = "";

    public static void main(String[] args) {

        // Create secure list
        SecureList<String> secureList = new SecureList<>();
        secureList.add("Java");
        secureList.add("is");
        secureList.add("the");
        secureList.add("best");
        secureList.add("programming");
        secureList.add("language");

        secureList.forEach(System.out::println);

        System.out.println("Get element by index 1: " + secureList.get(1));

        System.out.println("Size: " + secureList.size());

        SecureList<String> secureList2 = new SecureList<>();
        secureList2.add("C#");
        secureList2.add("is");
        secureList2.add("the");
        secureList2.add("best");
        secureList2.add("programming");
        secureList2.add("language");

        System.out.println("Is C# the best programming language ? " + secureList.equals(secureList2));

        System.out.println("Difference between two lists: ");
        secureList.difference(secureList2).forEach(System.out::println);

        // SecureList doesn't support delete operations
        try {
            System.out.println(secureList.remove(2));
        } catch (RuntimeException e){
            msg += e.getMessage() + "\n";
            count++;
        }
        try {
            System.out.println(secureList.remove("Java"));
        } catch (RuntimeException e){
            msg += e.getMessage() + "\n";

            count++;
        }
        try {
            secureList.clear();
        } catch (RuntimeException e){
            msg += e.getMessage() + "\n";
            count++;
        }

        System.out.println("Quantity of exceptions: " + count);
        System.out.println("Exception message: " + msg);

        //Time test
        ArrayList<Integer> integers1 = getIntegers();
        ArrayList<Integer> integers2 = getIntegers();
        System.out.println("Difference through removeAll, in millis: "
                                + differenceArrayList(integers1, integers2));
        System.out.println("Difference through secure list"
                            + " difference, in millis: "
                                + differenceSecureList(new SecureList<>(integers1), integers2));



    }

    private static ArrayList<Integer> getIntegers() {
        ArrayList<Integer> integers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            integers.add(random.nextInt(100));
        }
        return integers;
    }

    private static long differenceArrayList(ArrayList<Integer> integers1, ArrayList<Integer> integers2) {

        long t1 = System.currentTimeMillis();
        integers1.removeAll(integers2);
        long t2 = System.currentTimeMillis();
        return (t2 - t1);
    }

    private static long differenceSecureList(SecureList<Integer> integers1, ArrayList<Integer> integers2) {
        long t1 = System.currentTimeMillis();
        integers1.difference(integers2);
        long t2 = System.currentTimeMillis();
        return (t2 - t1);
    }

}
