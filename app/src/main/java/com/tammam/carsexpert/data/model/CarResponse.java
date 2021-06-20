package com.tammam.carsexpert.data.model;

import android.graphics.Movie;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Moustafa Tammam on 6/20/2021,
 * Alexandria, Egypt.
 */
public class CarResponse {

    @SerializedName("status")
    private int status;
    @SerializedName("data")
    private List<Car> data = new ArrayList<>();

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Car> getData() {
        return data;
    }

    public void setData(List<Car> data) {
        this.data = data;
    }
}
