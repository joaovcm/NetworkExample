package br.com.jvcm.networkexample.Dtos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OffersResponseDTO extends RestResponseDto {
    @SerializedName("offersDay")
    private List<Offer> offers;

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }
}
