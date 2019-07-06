package br.com.jvcm.networkexample.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.com.jvcm.networkexample.Adapter.OfferAdapter;
import br.com.jvcm.networkexample.Model.OfferDataSet;
import br.com.jvcm.networkexample.R;
import br.com.jvcm.networkexample.contracts.OfferContract;
import br.com.jvcm.networkexample.network.Repository;
import br.com.jvcm.networkexample.network.RetrofitConfiguration;
import br.com.jvcm.networkexample.presenter.OfferPresenter;
import io.reactivex.Observable;

public class FragmentOffer extends Fragment implements OfferContract.View {

    private RecyclerView mRecyclerView;
    private List<OfferDataSet> mOfferDataSet = new ArrayList<>();
    private OfferAdapter mOfferAdapter;
    private OfferContract.Presenter mOfferPresenter;
    private Repository mRepository;

    public static FragmentOffer newInstance (String value){
        FragmentOffer fragmentOffer = new FragmentOffer();
        return fragmentOffer;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_offer, container , true);

        mRepository = new Repository(RetrofitConfiguration.create());
        mRecyclerView = rootView.findViewById(R.id.recyclerView);
        mOfferPresenter = new OfferPresenter(this,mRepository );
        mOfferPresenter.doGetOffers();
        return rootView;
    }


   // public void testRX(){
      // List list =  Observable.fromArray(mOfferDataSet)
      //            .filter(v-> v.get(0).getNameProduct().contains("Exemplo"))
       //           .blockingFirst();
    //}

    @Override
    public void onShowOffers(List offerDataSet) {
        mOfferAdapter = new OfferAdapter(offerDataSet);
        mRecyclerView.setAdapter(mOfferAdapter);

    }

    @Override
    public void onErrorCaptureOffers() {

    }
}
