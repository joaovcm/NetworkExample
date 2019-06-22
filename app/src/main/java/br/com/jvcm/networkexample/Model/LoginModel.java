package br.com.jvcm.networkexample.Model;

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
        //todo validação do e-mail
        return true;
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