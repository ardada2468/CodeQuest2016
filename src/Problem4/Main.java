package Problem4;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/Problem4/Prob04.in.txt"));
        int runtime = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < runtime; i++) {
            String line = sc.nextLine();
           if(isAnagram(line.substring(0, line.indexOf('|')), line.substring(line.indexOf('|')))){
               System.out.println(line + " = ANAGRAM" );
           }else System.out.println(line + " = NOT AN ANAGRAM");
        }

    }
    public static boolean isAnagram(String one, String two){
        ArrayList <Character> oneArr = toArrayList(one);
        ArrayList <Character> twoArr = toArrayList(two);
        boolean isAnagram2 = true;
        for (Character character : oneArr) {
            if (!twoArr.contains(character)) {
                return false;
            }
        }
        return true;
    }
    public static ArrayList<Character> toArrayList (String x){
        ArrayList <Character> w = new ArrayList<Character>();
        for (char cs: x.toCharArray()) {
            w.add(cs);
        }
        return w;
    }
}
