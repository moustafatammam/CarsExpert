package com.tammam.carsexpert.viewmodel;

import android.app.Application;
import android.graphics.Movie;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.databinding.Observable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.tammam.carsexpert.data.model.Car;
import com.tammam.carsexpert.data.model.CarResponse;
import com.tammam.carsexpert.data.remote.ApiClient;
import com.tammam.carsexpert.data.remote.CarsService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Moustafa Tammam on 6/20/2021,
 * Alexandria, Egypt.
 */
public class CarsViewModel extends ViewModel implements Observable {

    private MutableLiveData<List<Car>> carsLiveData = new MutableLiveData<>();
    private CarsService carsService;

    public CarsViewModel() {
        carsService = ApiClient.getServiceInstance();
        callCars(2);
    }

    public MutableLiveData<List<Car>> getCars() {
        return carsLiveData;
    }


    public void callCars(int page) {
        Call<CarResponse> call = carsService.getCars(page);
        call.enqueue(new Callback<CarResponse>() {
            @Override
            public void onResponse(Call<CarResponse> call, Response<CarResponse> response) {
                if (response.body() != null) {
                    carsLiveData.setValue(response.body().getData());

                }
            }

            @Override
            public void onFailure(Call<CarResponse> call, Throwable t) {
                Log.e(this.getClass().getSimpleName(), "error");
            }
        });
    }

        @Override
        public void addOnPropertyChangedCallback (OnPropertyChangedCallback callback){

        }

        @Override
        public void removeOnPropertyChangedCallback (OnPropertyChangedCallback callback){

        }
    }
