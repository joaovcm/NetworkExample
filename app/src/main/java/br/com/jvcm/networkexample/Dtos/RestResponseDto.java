package br.com.jvcm.networkexample.Dtos;

import android.support.annotation.StringRes;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class RestResponseDto implements Serializable {

    @SerializedName("code")
    private String code;
    @SerializedName("message")
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
