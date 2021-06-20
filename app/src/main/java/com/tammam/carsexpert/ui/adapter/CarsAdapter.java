package com.tammam.carsexpert.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.tammam.carsexpert.R;
import com.tammam.carsexpert.data.model.Car;
import com.tammam.carsexpert.databinding.ViewCarBinding;

import java.util.List;

/**
 * Created by Moustafa Tammam on 6/20/2021,
 * Alexandria, Egypt.
 */
public class CarsAdapter extends RecyclerView.Adapter<CarsAdapter.CarHolder> {

    private List<Car> cars;
    private Context mContext;

    public CarsAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public CarHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewCarBinding viewCarBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.view_car, parent, false);
        return new CarHolder(viewCarBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CarHolder holder, int position) {
        holder.carBinding.setModel(cars.get(position));
    }

    @Override
    public int getItemCount() {
        return cars == null ? 0 : cars.size();
    }

    public class CarHolder extends RecyclerView.ViewHolder{

        ViewCarBinding carBinding;

        public CarHolder(@NonNull ViewCarBinding carBinding) {
            super(carBinding.getRoot());
            this.carBinding = carBinding;
        }
    }

    public void submitList(List<Car> cars) {
        this.cars = cars;
        notifyDataSetChanged();
    }


}
