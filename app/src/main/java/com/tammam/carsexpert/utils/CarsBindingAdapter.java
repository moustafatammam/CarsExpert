package com.tammam.carsexpert.utils;

import android.widget.ImageView;

import androidx.core.content.ContextCompat;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.tammam.carsexpert.R;

/**
 * Created by Moustafa Tammam on 6/20/2021,
 * Alexandria, Egypt.
 */
public class CarsBindingAdapter {

    @BindingAdapter("android:src")
    public static void setImageUrl(ImageView view, String url) {
        RequestOptions options = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(view.getContext()).load(url)
                .apply(options).into(view);
    }
}
