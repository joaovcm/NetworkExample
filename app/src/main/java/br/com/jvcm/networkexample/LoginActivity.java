package br.com.jvcm.networkexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import br.com.jvcm.networkexample.contracts.LoginContract;
import br.com.jvcm.networkexample.presenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity
        implements LoginContract.View {

    private Button btnLogin;

    //MVP Objects
    private LoginPresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this::onClickLogin);

        mPresenter = new LoginPresenter();

        //aplicar um text watcher nos campos edt
    }

    public void onClickLogin(View view) {
       //mPresenter.doValidEmail();
       //mPresenter.doValidPassord();
    }

    @Override
    public void onEnableButton() {
        mPresenter.doAuth();
    }

    @Override
    public void onAuthSuccess() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onAuthError() {
        //todo construir uma snakbar com fundo vermelhor com a mensagem de e-mail ou senha invalidos.
    }
}
