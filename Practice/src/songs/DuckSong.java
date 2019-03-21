package songs;

import java.util.Scanner;

public class DuckSong {

    private int getNum() {
        Scanner myScanner;
        int newNum;

        myScanner = new Scanner(System.in);
        System.out.println("How many ducks are there?");
        newNum = myScanner.nextInt();

        return newNum;
    }

    private void sing(int number) {
        for (int i = number; i > 0; i--) {
            if (i > 1) {
                System.out.println(i + " little ducks went swimming one day,");
            } else {
                System.out.println(i + " little duck went swimming one day,");
            }
            System.out.println("Over the hills and far away.");
            System.out.println("Mother Duck said:");
            System.out.print("'Quack");
            for (int j = 0; j < i - 1; j++) {
                System.out.print(", quack");
            }
            System.out.println("!'");
            if (i > 2) {
                System.out.println("But only " + (i - 1) + " little ducks came swimming back.");
            } else if (i > 1) {
                System.out.println("But only " + (i - 1) + " little duck came swimming back.");
            } else {
                System.out.println("And all " + number + " little ducks came swimming back!");
            }

            System.out.println();
        }
    }

    public static void singDucks() {
        DuckSong myDucks = new DuckSong();
        myDucks.sing(myDucks.getNum());
    }

}
