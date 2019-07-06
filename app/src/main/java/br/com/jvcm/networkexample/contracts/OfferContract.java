package br.com.jvcm.networkexample.contracts;

import java.util.List;

public interface OfferContract {
    interface View {
        void onShowOffers(List offerDataSet);

        void onErrorCaptureOffers();
    }

    interface Presenter {

        void doGetOffers();
    }
}
