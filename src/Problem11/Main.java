package Problem11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static ArrayList<Character> normal = new ArrayList<>();
    public static ArrayList<Character> upper = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        for (char a = 'a'; a <= 'z'; a++) {
            normal.add(a);
        }
        normal.add(' ');

        for (char a = 'A'; a <= 'Z'; a++) {
            upper.add(a);
        }
        upper.add(' ');
        Scanner sc = new Scanner(new File("src/Problem11/Prob11.in.txt"));
        int runtime = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < runtime; i++) {

            String line = sc.nextLine();

            if (line.equals("ENCRYPT")) {

                String key = sc.nextLine().toLowerCase();
                int runtime2 = sc.nextInt();

                for (int j = 0; j < runtime2 + 1; j++) {

                    String line2 = sc.nextLine();
                    encrypt(toArraylist(key), line2);

                }

            } else {

                String key = sc.nextLine().toLowerCase();
                int runtime2 = sc.nextInt();

                for (int j = 0; j < runtime2 + 1; j++) {

                    String line2 = sc.nextLine();
                    decrypt(toArraylist(key), line2);

                }
            }
        }
    }

    public static void encrypt(ArrayList<Character> key, String x) {
        String enStr = "";
        for (int i = 0; i < x.length(); i++) {

            if (Character.isSpaceChar(x.charAt(i))) {
                enStr += " ";

            } else if (Character.isUpperCase(x.charAt(i))) {

                enStr += Character.toUpperCase(key.get(upper.indexOf(x.charAt(i))));

            } else enStr += key.get(normal.indexOf(x.charAt(i)));
        }
        System.out.println(enStr);
    }

    public static void decrypt(ArrayList<Character> key, String x) {
        String deStr = "";
        for (int i = 0; i < x.length(); i++) {
            if (Character.isSpaceChar(x.charAt(i))) {

                deStr += " ";

            } else if (Character.isUpperCase(x.charAt(i))) {

                deStr += Character.toUpperCase(upper.get(key.indexOf(Character.toLowerCase(x.charAt(i)))));

            } else deStr += normal.get(key.indexOf(x.charAt(i)));
        }

        System.out.println(deStr);
    }

    public static ArrayList<Character> toArraylist(String x) {
        ArrayList<Character> w = new ArrayList<>();
        char[] arr = x.toCharArray();
        for (char s : arr) {
            w.add(s);
        }
        return w;
    }
}

class OtherClass{
    public static int i = 0;
    public static void  incr(){
        i++;
        System.out.println(i);
    }
}
