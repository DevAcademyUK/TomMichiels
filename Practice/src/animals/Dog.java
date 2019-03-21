package animals;

class Dog extends Animal{

    Dog(String name, String size, int age, String breed) {
        super(name, size, age, breed);

        switch (this.size) {
            case "small":
                this.cry = "yip yip";
                break;
            case "medium":
                this.cry = "woof";
                break;
            case "large":
                this.cry = "WOOF";
                break;
            default:
                this.cry = "woof";
                break;
        }

    }

}
