package br.com.jvcm.networkexample.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.jvcm.networkexample.Dtos.Offer;
import br.com.jvcm.networkexample.R;

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.DataObjectHolder> {

    private List<Offer> mDataset;

    public OfferAdapter(List<Offer> dataSet) {
         mDataset = dataSet;
    }

    @NonNull
    @Override
    public DataObjectHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View cellView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_offers, viewGroup, false);

        DataObjectHolder objectHolder = new DataObjectHolder(cellView);
        return objectHolder;
    }
    public void onBindViewHolder(DataObjectHolder holder, int i) {
        Offer set = mDataset.get(i);

        holder.tvProductName.setText(set.getName());
        holder.tvProductValue.setText(set.getValue());
        holder.tvProductDescription.setText(set.getDescription());
        Picasso.get()
                .load(set.getImg())
                .placeholder(R.drawable.ic_place_holder)
                .error(R.drawable.ic_place_holder)
                .into(holder.imgProduct);

    }

    public int getItemCount() {
        return mDataset.size();
    }

    public class DataObjectHolder extends RecyclerView.ViewHolder {
        TextView tvProductName;
        TextView tvProductDescription;
        TextView tvProductValue;
        ImageView imgProduct;


        public DataObjectHolder(@NonNull View itemView) {
            super(itemView);

            tvProductName = itemView.findViewById(R.id.tv_product_name);
            tvProductDescription = itemView.findViewById(R.id.tv_product_descripition);
            tvProductValue = itemView.findViewById(R.id.tv_product_value);
            imgProduct = itemView.findViewById(R.id.img_product);

        }
    }

}