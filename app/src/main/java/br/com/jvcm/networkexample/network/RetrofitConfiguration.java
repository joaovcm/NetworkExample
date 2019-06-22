package br.com.jvcm.networkexample.network;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfiguration {

   /**
    * Singleton Pattern
    */
    private static RetrofitConfiguration INSTANCE;

    private static final String BASE_URL = "http://private-bd8a09-joaovcm.apiary-mock.com";

    private RetrofitConfiguration() {

    }

    public static RetrofitConfiguration create() {
        if (INSTANCE == null) {
            INSTANCE = new RetrofitConfiguration();
        }
        return INSTANCE;
    }

    public API getApi() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(getClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(API.class);
    }


    private OkHttpClient getClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        return client;
    }

}
