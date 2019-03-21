package banking;

import java.util.Scanner;

//initial class. Not strictly necessary, but makes scaling to multiple users easier if implemented later
public class BankSystem {

    //our test user array. hardcoded below
    private static User[] users;

    //method to validate provided login info
    private void login (String userID, String pin) {

        for (User user : users) {
            if (userID.equals(user.userID)) {

                //only check PIN provided if user account exists

                if (pin.equals(user.pin)) {
                    //only let user in if they get the correct PIN
                    Session mySession = new Session(user);
                    mySession.getInput();
                    break;

                } else {
                    //let user know if their input failed
                    System.out.println("Invalid PIN.");
                    break;
                }

                //if reached end of loop and not matched userID

            }

            if (user.equals(users[2])) {
                System.out.println("User not found.");
            }
        }

    }

    //start here
    public static void main(String[] args) {
        //start here, then jump right in to getInput
        BankSystem myBank = new BankSystem();
        myBank.getInput();

    }

    //looping method that gets input from user and acts on it
    private void getInput() {

        String input;
        Scanner myScanner = new Scanner(System.in);
        //loop continually
        while (true) {
            //message user will see before any input, defining what options are available
            System.out.println("What would you like to do today?");
            System.out.println("(options are 'login' and 'exit')");
            input = myScanner.nextLine().toLowerCase();
            //convert input to lowercase for easier checking
            if (input.equals("exit")) {
                //break out of the loop and thus exit the program if user enters exit command
                break;
            } else if (input.equals("login")) {
                //if user enters login command, get inputs then feed them into validation method above
                String userID;
                String pin;

                System.out.println("Please enter your userID:");
                userID = myScanner.nextLine();

                System.out.println("Please enter your PIN:");
                pin = myScanner.nextLine();

                this.login(userID, pin);

            } else {
                //let user know if their input failed
                System.out.println("'" + input + "' is an invalid command.");

            }

        }

    }

    //account ids of test users
    private BankSystem () {
        users = new User[3];
        users[0] = new User("TestUser", "1234");
        users[1] = new User("username", "1111");
        users[2] = new User("TM8195", "9999");
    }

}
