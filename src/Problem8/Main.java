package Problem8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    //NOT WORKING YET!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/Problem8/Prob08.in.txt"));
        int runtime = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < runtime; i++) {
            int run = sc.nextInt();
            sc.nextLine();
            for (int j = 0; j < run; j++) {
                String  line = sc.nextLine();
                new song(split(line)[0], split(line)[1]);

            }
            ArrayList <String> x = new ArrayList<String>();
            x.addAll(song.SongsArt);
            Collections.sort(x);
            System.out.println(x);
            for (String art:x) {
                if(song.SongsArt.contains(art)){
                    System.out.println(song.SongsArt.get(song.SongsArt.indexOf(art)));
                }
            }
            System.out.println(song.SongList);
            song.clear();
        }
    }
    public static String[] split(String  x){
        return x.split(" - ");
    }

}
class song{
    String Name;
    String Artist;
    public static Map <String, ArrayList<song>> SongList = new HashMap<>();
    public static ArrayList <String> SongsArt = new ArrayList<String>();
    public static ArrayList <String> SongName = new ArrayList<String>();
    public song(String name, String artist) {
        Name = name;
        Artist = artist;
        if(SongList.containsKey(artist)){
            SongList.get(artist).add(this);
        }else{
            ArrayList <song> x = new ArrayList<>();
            x.add(this);
            SongList.put(artist,x);
        }
        SongsArt.add(Artist);
        SongName.add(Name);
    }
    public static void clear(){
        SongList.clear();
        SongsArt.clear();
        SongName.clear();

    }
}

