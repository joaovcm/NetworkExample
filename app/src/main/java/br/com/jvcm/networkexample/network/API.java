package br.com.jvcm.networkexample.network;

import br.com.jvcm.networkexample.Dtos.LoginRequestDto;
import br.com.jvcm.networkexample.Dtos.LoginResponseDto;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface API {

   String AUTH = "/auth";
   String OFFERS = "/offers";
   String LOGOUT = "/logout";

   @POST(AUTH)
   Observable<LoginResponseDto> auth(@Body LoginRequestDto loginRequestDto);

}
