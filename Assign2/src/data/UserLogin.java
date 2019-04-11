package data;

class UserLogin {

    private String username, password, userType, userId;

    boolean checkDetails (String[] input) {
        return username.equals(input[0]) && password.equals(input[1]);
    }

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
