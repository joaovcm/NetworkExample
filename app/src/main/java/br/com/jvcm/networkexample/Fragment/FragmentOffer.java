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

public class FragmentOffer extends Fragment {

    private RecyclerView mRecyclerView;
    private List<OfferDataSet> mOfferDataSet = new ArrayList<>();
    private OfferAdapter mOfferAdapter;

    public static FragmentOffer newInstance (String value){
        FragmentOffer fragmentOffer = new FragmentOffer();
        return fragmentOffer;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_offer, container , true);

        mOfferAdapter = new OfferAdapter(mOfferDataSet);
        mRecyclerView = rootView.findViewById(R.id.recyclerView);
        getMocks();
        mRecyclerView.setAdapter(mOfferAdapter);

        mOfferDataSet = new ArrayList<>();

        return rootView;
    }

    //todo mock
    private void getMocks(){
        OfferDataSet offer1 = new OfferDataSet();
        offer1.setNameProduct("Nome da oferta");
        offer1.setProductDescripition("Descrição da oferta");
        offer1.setImgProduct(0);

        mOfferDataSet.add(offer1);
    }
}
