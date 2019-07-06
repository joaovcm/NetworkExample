package br.com.jvcm.networkexample.network;

import br.com.jvcm.networkexample.Dtos.LoginRequestDto;
import br.com.jvcm.networkexample.Dtos.LoginResponseDto;
import br.com.jvcm.networkexample.Dtos.Offer;
import br.com.jvcm.networkexample.Dtos.OffersResponseDTO;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface API {

   String AUTH = "/auth";
   String OFFERS = "/offers";
   String LOGOUT = "/logout";

   @POST(AUTH)
   Observable<LoginResponseDto> auth(@Body LoginRequestDto loginRequestDto);

   @GET(OFFERS)
   Observable<OffersResponseDTO> offers(@Query("userId") String userId);



}
