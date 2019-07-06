package br.com.jvcm.networkexample.presenter;

import android.annotation.SuppressLint;

import br.com.jvcm.networkexample.Dtos.Offer;
import br.com.jvcm.networkexample.Dtos.OffersResponseDTO;
import br.com.jvcm.networkexample.Model.OfferDataSet;
import br.com.jvcm.networkexample.contracts.OfferContract;
import br.com.jvcm.networkexample.network.Repository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class OfferPresenter implements OfferContract.Presenter {

    private OfferContract.View mView;
    private Repository mRepository;
    private OfferDataSet mOfferDataSet;
    private CompositeDisposable mDisposable = new CompositeDisposable();

    public OfferPresenter(OfferContract.View view, Repository repository ){
        mView = view;
        mRepository = repository;
    }

    @SuppressLint("CheckResult")
    @Override
    public void doGetOffers() {
        mRepository.offers("123454")
                .doOnSubscribe(mDisposable::add)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<OffersResponseDTO>() {
                    @Override
                    public void onNext(OffersResponseDTO offersResponseDTO) {
                            mView.onShowOffers(offersResponseDTO.getOffers());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }


}
