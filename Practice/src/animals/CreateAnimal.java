package animals;

import java.util.Scanner;

public class CreateAnimal {

    private Scanner myScanner = new Scanner(System.in);

    private void getParams(String type) {
        String name, breed, size;
        int age;

        System.out.println("What's the name of the " + type + "?");
        name = myScanner.nextLine();

        System.out.println("What type of " + type + " is it?");
        breed = myScanner.nextLine();

        System.out.println("How large is " + name + "?\n" + "(Small, medium or large)");
        size = myScanner.nextLine();

        System.out.println("How old is " + name + "?");
        age = Integer.parseInt(myScanner.nextLine());

        //switch case used to ease further expansion
        switch (type) {
            case "dog":
                Dog myDog = new Dog (name, size, age, breed);
                myDog.returnValues();
                break;
            case "cat":
                Cat myCat = new Cat (name, size, age, breed);
                myCat.returnValues();
                break;
            default:
                System.out.println(type + " is not an animal we can currently create.");
        }

    }

    private void getAnimalType() {
        String animal;

        System.out.println("What animal would you like to create?");
        animal = myScanner.nextLine().toLowerCase();

        getParams(animal);
    }

    public static void main(String[] args) {
        CreateAnimal myCreator = new CreateAnimal();
        myCreator.getAnimalType();
    }

}
