package br.com.jvcm.networkexample.Model;

import android.text.TextUtils;
import android.util.Patterns;

import java.util.regex.Pattern;

public class LoginModel {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    private boolean isValidEmail() {
        if (email.isEmpty()) {
            return false;
        } else {
            return Patterns.EMAIL_ADDRESS.matcher(email).matches();
        }
    }

    private boolean isValidPassword() {
        if (password != null) {
            return password.length() >= 6;
        }
        return false;
    }

    public boolean isValidForm() {
        return isValidEmail() && isValidPassword();
    }
}