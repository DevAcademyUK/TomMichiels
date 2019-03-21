package banking;

import java.util.Scanner;

import static java.lang.Math.round;

class UserProfile {
    //user profile knows its id and pin, as well as having three linked accounts
    String userID;
    int pin;
    private Account current, joint, saving;
    //handles the transfer method
    private void transferFunds (Account src, Account dest) {

        double roundedAmount;
        String input;
        double tmpAmount;
        Scanner myScanner = new Scanner(System.in);

        System.out.println("How much are you transferring today?");
        input = myScanner.nextLine();
        tmpAmount = Double.parseDouble(input);
        roundedAmount = ((double)round(tmpAmount * 100)/ 100);

        if (roundedAmount > src.checkBalance()) {
            //checks if amount exceeds source balance
            System.out.println("Amount £" + roundedAmount + " exceeds source account balance.");
        } else {
            src.withdraw(roundedAmount);
            dest.deposit(roundedAmount);
            System.out.println("£" + roundedAmount + " transferred. Returning to options.");
        }


    }
    //asks user for chosen account and then returns reference to said account
    private Account selectAccount() {

        Scanner myScanner = new Scanner (System.in);
        String input;
        System.out.println("(options are 'current', 'saving', or 'joint')");
        input = myScanner.nextLine().toLowerCase();
        //switch on user input, to see which account they selected
        switch (input) {
            case "current":
                return this.current;
            case "saving":
                return this.saving;
            case "joint":
                return this.joint;
            default:
                //invalid selection returns no account
                System.out.println("Invalid account. Returning to options.");
                return null;
        }

    }
    //primary method that loops, receiving user input and acting on it
    void getInput() {

        Scanner myScanner = new Scanner (System.in);
        String input;
        //loop until log out is chosen
        while (true) {
            //set of messages defining possible inputs
            System.out.println("Welcome, " + userID + ". What would you like to do today?\n"
                    + "(options are 'transfer', 'withdraw', 'deposit', 'balance', and 'log out')");
            input = myScanner.nextLine().toLowerCase();
            //log out is a special case that breaks the loop before the switch body is reached
            if (input.equals("log out")) { break; }

            switch (input) {
                case "balance":
                    //when balance is chosen, asks for account
                    //then returns the value of the checkBalance method of that account
                    double roundedBalance;

                    System.out.println("Which account are you accessing today?");
                    Account balanceAccount = this.selectAccount();
                    //prevents accessing a null value if account selected was invalid
                    if (balanceAccount == null) { break; }
                    roundedBalance = balanceAccount.checkBalance();
                    System.out.println("This account holds £" + roundedBalance + ".");

                    break;
                case "deposit":

                    double depositAmount;
                    System.out.println("Which account are you accessing today?");
                    Account depositAccount = this.selectAccount();

                    if (depositAccount == null) { break; }
                    //prevents accessing a null value if account selected was invalid
                    System.out.println("How much are you depositing today?");
                    input = myScanner.nextLine();
                    //rounds input amount
                    depositAmount = Double.parseDouble(input);
                    System.out.println("£" + depositAmount + " deposited. Returning to options.");
                    depositAccount.deposit(depositAmount);

                    break;
                case "withdraw":

                    double roundedOut;
                    System.out.println("Which account are you accessing today?");
                    Account withdrawAccount = this.selectAccount();
                    if (withdrawAccount == null) { break; }

                    System.out.println("How much are you withdrawing today?");
                    input = myScanner.nextLine();
                    roundedOut = ((double)round(Double.parseDouble(input) * 100)/ 100);
                    //rounds chosen amount
                    if (roundedOut > withdrawAccount.checkBalance()) {
                        //checks if trying to remove more money than account holds
                        System.out.println("Amount £" + roundedOut + " exceeds account balance.");
                    } else {
                        withdrawAccount.withdraw(roundedOut);
                        System.out.println("£" + roundedOut + " withdrawn. Returning to options.");
                    }

                    break;
                case "transfer":

                    System.out.println("Please select source account.");
                    Account transferSrcAccount = this.selectAccount();
                    if (transferSrcAccount == null) { break; }
                    System.out.println("Please select destination account.");
                    Account transferDestAccount = this.selectAccount();
                    if (transferDestAccount == null) { break; }
                    transferFunds(transferSrcAccount, transferDestAccount);
                    //calls tranferFunds method with chosen accounts
                    break;
                default:
                    //let user know if their input failed
                    System.out.println("Invalid input '" + input + "'.");
                    //wait for enter key from user
                    myScanner.nextLine();
                    break;
            }

        }
    }
    //requires id and pin to initialise, and provides some starting funds to own accounts
    UserProfile(String inputID, int inputPin) {
        this.userID = inputID;
        this.pin = inputPin;
        this.current = new Account (100.0);
        this.joint = new Account (100.0);
        this.saving = new Account (100.0);
    }

}
