package games;

import java.util.Scanner;

public class MultiplicationDoodad {

    private Scanner myScanner = new Scanner(System.in);

    private void calculate(int number, int multiplier) {
        for (int i = 1; i < multiplier; i++) {
            System.out.println(i + " x " + number + " = " + i * number);
        }
    }

    private void getValues() {
        int number, multiplier;

        System.out.println("What number would you like the multiplication tables for?");
        number = Integer.parseInt(myScanner.nextLine());

        System.out.println("What is the maximum multiplication you wish to calculate?");
        multiplier = Integer.parseInt(myScanner.nextLine());

        calculate(number, multiplier);

    }

    public static void main(String[] args) {
        MultiplicationDoodad myDoodad = new MultiplicationDoodad();
        myDoodad.getValues();
    }

}
