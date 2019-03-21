package songs;

import java.util.Scanner;

public class BottleSong {

    private String getItem() {
        Scanner myScanner;
        String wordIn;

        myScanner = new Scanner(System.in);
        System.out.println("What is that on the wall (Singular, please)?");
        wordIn = myScanner.nextLine();

        return wordIn;
    }

    private int getNumber(String item) {
        Scanner myScanner;
        int numIn;

        myScanner = new Scanner(System.in);
        System.out.println("How many " + item + "s are there on the wall?");
        numIn = myScanner.nextInt();

        return numIn;
    }

    private String getModifier(String item, int number) {
        Scanner myScanner;
        String modIn;

        myScanner = new Scanner(System.in);
        System.out.print("What type of " + item);
        if (number == 1) {
            System.out.println(" is it?");
        } else {
            System.out.println(" are they?");
        }
        modIn = myScanner.nextLine();

        return modIn;
    }

    private void sing(String item, int amount, String modifier) {
        String plural = item + "s";
        String word;
        if (amount > 1) {
            word = plural;
        } else {
            word = item;
        }
        int nextI;

        for (int i = amount; i > 0; i--) {
            nextI = i - 1;
            System.out.println(i + " " + word + " of " + modifier + " on the wall.");
            System.out.println(i + " " + word + " of " + modifier + ".");
            System.out.println("Take one down.");
            System.out.println("Pass it around.");

            if (nextI == 0) {
                System.out.println("No more " + plural + " of " + modifier + " on the wall.");
            } else if (nextI == 1) {
                word = item;
            } else {
                System.out.println(nextI + " " + word + " of " + modifier + " on the wall.");
            }
            System.out.println();
        }
    }

    public static void singBottles() {
        BottleSong mySong;
        String item;
        String modifier;
        int amount;

        mySong = new BottleSong();
        item = mySong.getItem();
        amount = mySong.getNumber(item);
        modifier = mySong.getModifier(item, amount);
        mySong.sing(item, amount, modifier);
    }

}