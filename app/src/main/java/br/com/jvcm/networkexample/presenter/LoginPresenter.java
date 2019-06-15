package br.com.jvcm.networkexample.presenter;

import br.com.jvcm.networkexample.Dtos.LoginRequestDto;
import br.com.jvcm.networkexample.contracts.LoginContract;
import br.com.jvcm.networkexample.network.Repository;

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View mView;
    private Repository mRepository;

    public LoginPresenter(LoginContract.View view, Repository repository) {
        mView = view;
        mRepository = repository;
    }

    @Override
    public void doValidEmail(String email) {

    }

    @Override
    public void doValidPassord(String password) {

    }


    @Override
    public void doAuth(String email, String password) {
        LoginRequestDto request = new LoginRequestDto();
        request.setEmail(email);
        request.setPassword(password);

        mRepository.auth(request);
        mView.onAuthSuccess();
    }
}
