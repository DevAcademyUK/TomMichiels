package dogkennel;
import java.util.Scanner;

public class Kennel {
    private Dog[] kennel = null;

    private Dog createDog() {
        Scanner myScanner = new Scanner(System.in);
        String name, breed;
        int age;
        Dog newDog;

        System.out.println("What would you like to name your Dog?");
        name = myScanner.nextLine();
        newDog = new Dog(name);

        System.out.println("What breed is your Dog?");
        breed = myScanner.nextLine();
        newDog.setBreed(breed);

        System.out.println("How old is your Dog?");
        age = myScanner.nextShort();
        newDog.setAge(age);

        return newDog;
    }

    private void addDog(Dog newDog) {
        if (this.kennel == null) {
            this.kennel = new Dog[1];
            this.kennel[0] = newDog;
        } else {
            int size = this.kennel.length;
            Dog[] oldKennel = this.kennel;
            Dog[] newKennel = new Dog[size + 1];
            System.arraycopy(oldKennel, 0, newKennel, 0, size);
            newKennel[size] = newDog;
            this.kennel = newKennel;
        }
    }

    //TODO make this public when another class added
    private void addDogs(){
        Scanner myScanner = new Scanner(System.in);
        int dogNumber;

        System.out.println("How many dogs are you adding today?");
        dogNumber = myScanner.nextInt();

        for (int i = 0; i < dogNumber; i++) {
            this.addDog(this.createDog());
        }
    }
    //TODO make this public when another class added
    private void listDogs() {

        for (Dog d : this.kennel) {
            d.getAll();
        }
    }

    public static void main(String[] args) {
        Kennel myKennel = new Kennel();
        myKennel.addDogs();
        myKennel.listDogs();
    }

}
