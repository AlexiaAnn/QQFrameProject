package com.example.alexiaann.qqfragmentproject.Modal;

/**
 * Created by AlexiaAnn on 2016/8/13 0013.
 */
public class MessageListModal {

    private int imageResId =-1;
    private String userName = "";
    private String time = "";
    private String message = "";

    public MessageListModal(int imageResId, String userName, String time, String message) {
        this.imageResId = imageResId;
        this.userName = userName;
        this.time = time;
        this.message = message;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
