package com.alticeacademy.lost;

public class Post {

    private String postID;
    private  String nameLost;
    private  String postDescription;
    private  String datePost;
    private  String userName;
    private String imageLost;

    public Post() {
    }

    public Post(String postID, String nameLost, String postDescription, String datePost, String userName, String imageLost) {
        this.postID = postID;
        this.nameLost = nameLost;
        this.postDescription = postDescription;
        this.datePost = datePost;
        this.userName = userName;
        this.imageLost = imageLost;
    }

    public Post(String postID, String nameLost, String datePost, String userName) {
        this.postID = postID;
        this.nameLost = nameLost;
        this.datePost = datePost;
        this.userName = userName;
    }


    public String getPostID() {
        return postID;
    }

    public void setPostID(String postID) {
        this.postID = postID;
    }

    public String getNameLost() {
        return nameLost;
    }

    public void setNameLost(String nameLost) {
        this.nameLost = nameLost;
    }

    public String getPostDescripcion() {
        return postDescription;
    }

    public void setPostDescription(String postDescripcion) {
        this.postDescription = postDescripcion;
    }

    public String getDatePost() {
        return datePost;
    }

    public void setDatePost(String datePost) {
        this.datePost = datePost;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getImageLost() {
        return imageLost;
    }

    public void setImageLost(String imageLost) {
        this.imageLost = imageLost;
    }


}
