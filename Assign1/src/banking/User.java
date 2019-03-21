package banking;

class User {

    String userID, pin;

    Account current, joint, saving;

    User (String inputID, String inputPin) {
        this.userID = inputID;
        this.pin = inputPin;
        this.current = new Account (100.0);
        this.joint = new Account (100.0);
        this.saving = new Account (100.0);
    }

}
