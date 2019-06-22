package br.com.jvcm.networkexample.presenter;

import br.com.jvcm.networkexample.contracts.OfferContract;
import br.com.jvcm.networkexample.network.Repository;

public class OfferPresenter implements OfferContract.Presenter {

    private OfferContract.View mView;
    private Repository mRepository;
}
