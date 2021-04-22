package Problem5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/Problem5/Prob05.in.txt"));
        int runtime = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < runtime; i++) {
            String line = sc.nextLine();
            Double db = Double.parseDouble(line.substring(1));
            System.out.println("Total of the bill: $" + db );
            System.out.println("15% = " + round(getTip(.15, db), 2));
            System.out.println("18% = " + round(getTip(.18, db), 2));
            System.out.println("20% = " +  round(getTip(.20, db), 2));

        }
    }

    public static double getTip(double percent, double amt){
        return amt*(percent);
    }
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

}
