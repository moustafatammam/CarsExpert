package com.tammam.carsexpert.data.remote;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Moustafa Tammam on 6/20/2021,
 * Alexandria, Egypt.
 */
public class ApiClient {

    private static final String BASE_URL = "http://demo1585915.mockable.io/api/v1/";

    private static final OkHttpClient client;

    private static CarsService serviceInstance;

    private static final Object lock = new Object();

    static {
        client = new OkHttpClient.Builder()
                .build();
    }
    public static CarsService getServiceInstance(){
        synchronized (lock){
            if(serviceInstance == null){
                serviceInstance = getClient().create(CarsService.class);
            }
        }
        return serviceInstance;
    }
    private static Retrofit retrofit = null;

    private static Retrofit getClient(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
        }
        return retrofit;
    }
}
