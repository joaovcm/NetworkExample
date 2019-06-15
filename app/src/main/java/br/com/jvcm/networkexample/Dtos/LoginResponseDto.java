package br.com.jvcm.networkexample.Dtos;

import android.support.annotation.DrawableRes;

public class LoginResponseDto {
 private  String name;
 private String LastName;
 private String NickName;
 private String UserType;
 private String UserID;
 @DrawableRes
 private int ImgClient;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getNickName() {
        return NickName;
    }

    public void setNickName(String nickName) {
        NickName = nickName;
    }

    public String getUserType() {
        return UserType;
    }

    public void setUserType(String userType) {
        UserType = userType;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public int getImgClient() {
        return ImgClient;
    }

    public void setImgClient(int imgClient) {
        ImgClient = imgClient;
    }
}
