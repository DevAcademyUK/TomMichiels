package dogkennel;

public class Dog {
    private String name;
    private int age;
    private String breed;

    public void setBreed (String breedIn) {
        this.breed = breedIn;
    }

    public void setAge(int ageIn) {
        this.age = ageIn;
    }
/*
    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getBreed() {
        return this.breed;
    }
*/
    public void getAll() {
        System.out.print("My name is " + name + ", and I am a ");
        if (age == 0) {
            System.out.println ("newborn " + breed + ".");
        } else {
            System.out.println (age + " year old " + breed + ".");
        }
        System.out.println ("Woof.");
    }

    Dog(String nameIn) {
        this.name = nameIn;
        this.age = 0;
        this.breed = "Mutt";
    }

}
