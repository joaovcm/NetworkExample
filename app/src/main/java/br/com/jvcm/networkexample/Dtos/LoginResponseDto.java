package br.com.jvcm.networkexample.Dtos;


import com.google.gson.annotations.SerializedName;

/**
 * DTO - Data Transfer Object
 * {
 * "userId": "1234",
 * "name" : "Joao Vitor",
 * "lastName": "Cremom",
 * "nickName": "Joao",
 * "img":"https://ogimg.infoglobo.com.br/in/23721458-5df-9d9/FT1086A/384/83041618_TOPSHOTBrazils-Neymar-warms-up-before-a-friendly-football-match-against-Qatar-at-th.jpg",
 * "userType": "BUYER",
 * "sessionToken": "dsadsadasdas3123123123"
 * }
 */
public class LoginResponseDto extends RestResponseDto {
    private String name;
    private String lastName;
    private String nickName;
    private String userType;
    private String userId;
    @SerializedName("img")
    private String imgClient;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getImgClient() {
        return imgClient;
    }

    public void setImgClient(String imgClient) {
        this.imgClient = imgClient;
    }
}
