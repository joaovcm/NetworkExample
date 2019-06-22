package br.com.jvcm.networkexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this::onClickLogin);

        mRepository = new Repository(RetrofitConfiguration.create());
        mPresenter = new LoginPresenter(this, mRepository);
        mfragmentLogin = (FragmentLogin) getSupportFragmentManager().findFragmentById(R.id.login_fragment);

        //aplicar um text watcher nos campos edt
    }
  /*  et1.addTextChangedListener(new TextWatcher() {
      @Override
         public void onTextChanged(CharSequence s, int start, int before, int count) {

        // TODO Auto-generated method stub
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        // TODO Auto-generated method stub
    }

    @Override
    public void afterTextChanged(Editable s) {

        // TODO Auto-generated method stub
    }
}); */


    public void onClickLogin(View view) {
        // mPresenter.doValidEmailq();
        //mPresenter.doValidPassord();q
        mPresenter.doAuth(mfragmentLogin.getEmail(),
                mfragmentLogin.getPassword());
    }

    @Override
    public void onEnableButton() {
        btnLogin.setEnabled(true);
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

    @Override
    protected void onDestroy() {
        mPresenter.disposable();
        super.onDestroy();
    }
}
