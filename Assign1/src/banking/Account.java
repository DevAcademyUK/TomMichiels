package banking;

import static java.lang.Math.round;

class Account {
    //account object holds on to the balance value, but prevents outside access
    private double balance;
    //deposit given double
    void deposit(double in) {
        this.balance = this.balance + in;
    }
    //withdraws given amount
    void withdraw(double out) {

        this.balance = this.balance - out;

    }
    //returns a rounded to 2dp version of the balance (it is held at more decimal places, for calculation purposes)
    double checkBalance() {

        return ((double) round(this.balance * 100)/ 100);

    }
    //requires initial balance to be declared
    Account (double initBalance) {

        this.balance = initBalance;

    }

}
