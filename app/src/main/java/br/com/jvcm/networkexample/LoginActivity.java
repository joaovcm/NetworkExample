package br.com.jvcm.networkexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import br.com.jvcm.networkexample.Fragment.FragmentLogin;
import br.com.jvcm.networkexample.contracts.LoginContract;
import br.com.jvcm.networkexample.network.Repository;
import br.com.jvcm.networkexample.network.RetrofitConfiguration;
import br.com.jvcm.networkexample.presenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity
        implements LoginContract.View {

    private Button btnLogin;

    //MVP Objects
    private LoginPresenter mPresenter;
    private Repository mRepository;
    private FragmentLogin mfragmentLogin;
    private Snackbar snackbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this::onClickLogin);

        mRepository = new Repository(RetrofitConfiguration.create());
        mPresenter = new LoginPresenter(this, mRepository);
        mfragmentLogin = (FragmentLogin) getSupportFragmentManager().findFragmentById(R.id.login_fragment);
    }

    public void onClickLogin(View view) {
        mPresenter.doAuth(mfragmentLogin.getEmail(),
                mfragmentLogin.getPassword());
    }

    @Override
    public void onEnableButton(boolean isEnable) {
        btnLogin.setEnabled(isEnable);
    }

    @Override
    public void onAuthSuccess() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onAuthError() {
        Snackbar.make(mfragmentLogin.getView(),
                "email ou senha incorreto",
                Snackbar.LENGTH_SHORT)
                .show();
    }

    public void validEmail(String email) {
        mPresenter.doValidEmail(email);
    }

    public void validPassword(String password) {
        mPresenter.doValidPassord(password);
    }

    @Override
    protected void onDestroy() {
        mPresenter.disposable();
        super.onDestroy();
    }
}
