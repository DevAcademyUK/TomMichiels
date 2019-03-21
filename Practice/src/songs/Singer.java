package songs;

import java.util.Scanner;


public class Singer {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        String songName;


        System.out.println("What song would you like me to sing?");
        System.out.println("(Current options are 'ducks' or 'bottles')");
        songName = myScanner.nextLine();

        if (songName.equals("ducks")) {
            DuckSong.singDucks();
        } else if (songName.equals("bottles")) {
            BottleSong.singBottles();
        } else {
            System.out.println("That wasn't one of the options...");
        }


    }

}
