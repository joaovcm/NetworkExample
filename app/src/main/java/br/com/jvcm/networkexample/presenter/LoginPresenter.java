package br.com.jvcm.networkexample.presenter;

import android.annotation.SuppressLint;
import android.util.Log;

import br.com.jvcm.networkexample.Dtos.LoginRequestDto;
import br.com.jvcm.networkexample.Dtos.LoginResponseDto;
import br.com.jvcm.networkexample.contracts.LoginContract;
import br.com.jvcm.networkexample.network.Repository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View mView;
    private Repository mRepository;

    private CompositeDisposable mDisposable = new CompositeDisposable();

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


    @SuppressLint("CheckResult")
    @Override
    public void doAuth(String email, String password) {
        LoginRequestDto request = new LoginRequestDto();
        request.setEmail(email);
        request.setPassword(password);


        mRepository.auth(request)
                .doOnSubscribe(mDisposable::add)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<LoginResponseDto>() {
                    @Override
                    public void onNext(LoginResponseDto loginResponseDto) {
                        Log.v("TAG", "Solicitação de login com sucesso");
                        loginResponseDto.getName();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG", "Erro requisição login", e);
                    }

                    @Override
                    public void onComplete() {
                        Log.v("TAG", "Solicitação de login completa");
                    }
                });
        mView.onAuthSuccess();
    }

    @Override
    public void disposable() {
        mDisposable.dispose();
    }

}
