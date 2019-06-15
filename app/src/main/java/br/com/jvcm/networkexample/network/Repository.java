package br.com.jvcm.networkexample.network;

import br.com.jvcm.networkexample.Dtos.LoginRequestDto;
import br.com.jvcm.networkexample.Dtos.LoginResponseDto;
import io.reactivex.Observable;

public class Repository implements API {

    private API api;

    public Repository(RetrofitConfiguration configuration){
        api = configuration.getApi();
    }


    @Override
    public Observable<LoginResponseDto> auth(LoginRequestDto loginRequestDto) {
        return api.auth(loginRequestDto);
    }
}
