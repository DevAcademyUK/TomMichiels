package data;

//class to hold login details

class UserLogin {

    //keeps these variables - un and pw for obv reasions, usertype to know which type of session to log in to,
    //and userId to know which object applies to the user logged in
    private String username, password, userType, userId;

    //by disallowing any access to username or password after creation, one can allow un and pw to be checked against
    //without ever being directly viewable
    boolean checkDetails (String[] input) {
        return username.equals(input[0]) && password.equals(input[1]);
    }

    //generic getters
    //TODO add setters to allow changing of these fields if the associated employee object is edited
    // (say, if someone is promoted from hr to hr manager)
    String getType() {
        return  userType;
    }

    String getId() {
        return userId;
    }

    UserLogin(String username, String password, String userType, String userId) {
        this.username = username;
        this.password = password;
        this.userType = userType;
        this.userId = userId;
    }

}
