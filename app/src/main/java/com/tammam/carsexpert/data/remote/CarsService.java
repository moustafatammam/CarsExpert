package com.tammam.carsexpert.data.remote;

import com.tammam.carsexpert.data.model.CarResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Moustafa Tammam on 6/20/2021,
 * Alexandria, Egypt.
 */
public interface CarsService {

    @GET("cars")
    Call<CarResponse> getCars(@Query("page") int page);

}
