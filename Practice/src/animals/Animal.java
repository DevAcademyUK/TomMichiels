package animals;

class Animal {

    private String name, breed;
    String size, cry = "";
    private int age;

    void returnValues () {
        System.out.println("Hello, human, " + cry + ".");
        System.out.println("I am a " + age + " year old " + breed + ", called " + name + ", " + cry + ".");
    }

    Animal (String name, String size, int age, String breed) {
        this.name = name;
        this.size = size.toLowerCase();
        this.age = age;
        this.breed = breed.toLowerCase();
    }

}
