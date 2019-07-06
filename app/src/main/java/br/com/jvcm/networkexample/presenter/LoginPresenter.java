package br.com.jvcm.networkexample.presenter;

import android.annotation.SuppressLint;
import android.util.Log;

import br.com.jvcm.networkexample.Dtos.LoginRequestDto;
import br.com.jvcm.networkexample.Dtos.LoginResponseDto;
import br.com.jvcm.networkexample.Model.LoginModel;
import br.com.jvcm.networkexample.contracts.LoginContract;
import br.com.jvcm.networkexample.network.Repository;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View mView;
    private Repository mRepository;
    private LoginModel loginModel;
    private CompositeDisposable mDisposable = new CompositeDisposable();

    public LoginPresenter(LoginContract.View view, Repository repository) {
        mView = view;
        mRepository = repository;
        loginModel = new LoginModel();
    }

    @Override
    public void doValidEmail(String email) {
        Log.v("TAG", "doValidEmail: " + email);
        loginModel.setEmail(email);
        validForm();
    }

    @Override
    public void doValidPassord(String password) {
        Log.v("TAG", "doValidPassword: " + password);
        loginModel.setPassword(password);
        validForm();
    }

    public void validForm() {
        mView.onEnableButton(loginModel.isValidForm());
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
                .subscribe(new Observer<LoginResponseDto>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginResponseDto loginResponseDto) {
                        mView.onAuthSuccess();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.onAuthError();
                    }

                    @Override
                    public void onComplete() {

                    }
                });


//                .subscribeWith(new DisposableObserver<LoginResponseDto>() {
//                    @Override
//                    public void onNext(LoginResponseDto loginResponseDto) {
//                        Log.v("TAG", "Solicitação de login com sucesso");
//                        mView.onAuthSuccess();
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.e("TAG", "Erro requisição login", e);
//                        //mView.onAuthError();
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.v("TAG", "Solicitação de login completa");
//                    }
//                });

    }

    @Override
    public void disposable() {
        mDisposable.dispose();
    }

}
