package br.com.jvcm.networkexample.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.jvcm.networkexample.Model.OfferDataSet;
import br.com.jvcm.networkexample.R;

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.DataObjectHolder> {

    private List<OfferDataSet> mDataset;

    public OfferAdapter(List<OfferDataSet> mOfferDataSet) {

    }

    @NonNull
    @Override
    public DataObjectHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View cellView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_offers, viewGroup, false);

        DataObjectHolder objectHolder = new DataObjectHolder(cellView);
        return objectHolder;
    }
    public void onBindViewHolder(DataObjectHolder holder, int i) {
        OfferDataSet set = mDataset.get(i);


        holder.tvProductName.setText(set.getNameProduct());
        holder.tvProductDescription.setText(set.getProductDescripition());
        holder.imgProduct.setImageResource(set.getImgProduct());

    }

    public int getItemCount() {
        return mDataset.size();
    }

    public class DataObjectHolder extends RecyclerView.ViewHolder {
        TextView tvProductName;
        TextView tvProductDescription;
        ImageView imgProduct;


        public DataObjectHolder(@NonNull View itemView) {
            super(itemView);

            tvProductName = itemView.findViewById(R.id.tv_product_name);
            tvProductDescription = itemView.findViewById(R.id.tv_product_descripition);
            imgProduct = itemView.findViewById(R.id.img_product);

        }
    }

}