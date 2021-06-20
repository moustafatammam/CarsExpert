package com.tammam.carsexpert.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.databinding.BaseObservable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Moustafa Tammam on 6/20/2021,
 * Alexandria, Egypt.
 */
public class Car extends BaseObservable implements Parcelable {


    @SerializedName("id")
    private int id;
    @SerializedName("brand")
    private String brand;
    @SerializedName("constractionYear")
    private String constractionYear;
    @SerializedName("isUsed")
    private boolean isUsed;
    @SerializedName("imageUrl")
    private String imageUrl;


    protected Car(Parcel in) {
        id = in.readInt();
        brand = in.readString();
        constractionYear = in.readString();
        isUsed = in.readByte() != 0;
        imageUrl = in.readString();
    }

    public static final Creator<Car> CREATOR = new Creator<Car>() {
        @Override
        public Car createFromParcel(Parcel in) {
            return new Car(in);
        }

        @Override
        public Car[] newArray(int size) {
            return new Car[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getConstractionYear() {
        return constractionYear;
    }

    public void setConstractionYear(String constractionYear) {
        this.constractionYear = constractionYear;
    }

    public boolean getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(boolean isUsed) {
        this.isUsed = isUsed;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(brand);
        dest.writeString(constractionYear);
        dest.writeByte((byte) (isUsed ? 1 : 0));
        dest.writeString(imageUrl);
    }
}
