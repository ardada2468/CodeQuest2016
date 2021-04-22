package Problem13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/Problem13/Prob13.in.txt"));
        int runtime = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < runtime; i++) {
            String line = sc.nextLine();
            int sum = Integer.parseInt(line.substring(line.indexOf("=") + 1));
            String possibleFactors = sc.nextLine();
            possibleFactors = possibleFactors.replace(",", " ");
            Scanner scanner = new Scanner(possibleFactors);
            ArrayList<Integer> factors = new ArrayList<>();
            while (scanner.hasNextInt()) {
                factors.add(scanner.nextInt());
            }
            ArrayList sums = getSums2(sum, factors);
            Collections.sort(sums);
            for (Object o : sums) {
                System.out.println(o);
            }
        }
    }

    public static int howMany(ArrayList<Integer> x, int sp){
        int howMany = 0;
        for (int w: x) {
            if(w == sp){
                howMany++;
            }

        }
        return howMany;
    }

    public static Map<Integer, Integer> updateMap(Map<Integer, Integer> x, int w){
        if(x.containsKey(w)){
            x.replace(w, x.get(w)+1);
        }else x.put(w, 1);
        return x;
    }
    public static ArrayList<String> getSums2(int sum, ArrayList Factors) {
        ArrayList <String> Sums = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    if (i + j + k == sum && (Factors.contains(i) && (Factors.contains(j) && Factors.contains(k)))) {
                        Map <Integer, Integer>  numbs = new HashMap<>();
                        numbs =  updateMap(numbs, i);
                        numbs =   updateMap(numbs, j);
                        numbs =  updateMap(numbs, k);
                        if(numbs.get(i) <= howMany(Factors,i) && ((numbs.get(j) <= howMany(Factors, j)) && (numbs.get(k) <= howMany(Factors,k ))))
                            Sums.add(i + "+" + j + "+" + k);
                    }
                    }
                }
            }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(i+j == sum && (Factors.contains(i) && Factors.contains(j))){
                    Sums.add(i + "+" + j);
                }
            }

        }
        return Sums;
    }
}