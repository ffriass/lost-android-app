package com.alticeacademy.lost;

public class Post extends BaseEntity {

    private  String postID;
    private  String lostName;
    private  String postDescription;
    private  String postDate;
    private  String userName;
    private  String imageLostURL = "http://vinrosa.com/example/pineapple.jpg";
    private String userFaceURL;

    public Post() {
    }

    public Post(String postID, String nameLost, String postDescription, String datePost, String userName, String imageLost) {
        this.postID = postID;
        this.lostName = nameLost;
        this.postDescription = postDescription;
        this.postDate = datePost;
        this.userName = userName;
        this.imageLostURL = imageLost;
    }

    public Post(String postID, String nameLost, String datePost, String userName) {
        this.postID = postID;
        this.lostName = nameLost;
        this.postDate = datePost;
        this.userName = userName;
    }


    public String getPostID() {
        return postID;
    }

    public void setPostID(String postID) {
        this.postID = postID;
    }

    public String getLostName() {
        return lostName;
    }

    public void setLostName(String lostName) {
        this.lostName = lostName;
    }

    public String getPostDescripcion() {
        return postDescription;
    }

    public void setPostDescription(String postDescripcion) {
        this.postDescription = postDescripcion;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getImageLostURL() {
        return imageLostURL;
    }

    public void setImageLostURL(String imageLostURL) {
        this.imageLostURL = imageLostURL;
    }

    public String getUserFaceURL() {
        return userFaceURL;
    }

    public void setUserFaceURL(String userFaceURL) {
        this.userFaceURL = userFaceURL;
    }


}
