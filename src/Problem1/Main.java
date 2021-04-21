package Problem1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("C:\\Users\\ardad\\IdeaProjects\\CodeQuest2016\\src\\Problem1\\Prob01.in.txt"));
        int runtTimes = sc.nextInt();
        for (int i = 0; i < runtTimes; i++) {
            int gridsize = sc.nextInt();
            printGrid(gridsize);
        }
    }


    public static void printGrid(int i){
        for (int j = 0; j < i; j++) {
            for (int k = 0; k < i; k++) {
                System.out.print("#\t");
            }
            System.out.println();
        }
    }
}
