package com.alticeacademy.lost;

public class User extends BaseEntity {


    private String userName;
    private String userLastName;
    private String userID;
    private String userPhotoURL;

    public User(String userID, String userName, String userLastName) {
        this.userName = userName;
        this.userLastName = userLastName;
        this.userID = userID;
    }


    public User(String userID, String userName, String userLastName, String userPhoto) {
        this.userName = userName;
        this.userLastName = userLastName;
        this.userID = userID;
        this.userPhotoURL = userPhoto;
    }

    public String getUserPhotoURL() {
        return userPhotoURL;
    }

    public void setUserPhotoURL(String userPhotoURL) {
        this.userPhotoURL = userPhotoURL;
    }



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

}
