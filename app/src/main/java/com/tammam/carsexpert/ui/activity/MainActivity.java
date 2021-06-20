package com.tammam.carsexpert.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.tammam.carsexpert.R;
import com.tammam.carsexpert.data.model.Car;
import com.tammam.carsexpert.databinding.ActivityMainBinding;
import com.tammam.carsexpert.ui.adapter.CarsAdapter;
import com.tammam.carsexpert.viewmodel.CarsViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private CarsViewModel viewModel;
    private ActivityMainBinding binding;
    private CarsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(CarsViewModel.class);

        setupCarsList();
        populateUi();

    }

    private void setupCarsList() {
        adapter = new CarsAdapter(this);
        binding.carsRecycler.setLayoutManager(new LinearLayoutManager(this));
        binding.carsRecycler.setAdapter(adapter);

    }

    private void populateUi() {

        viewModel.getCars().observe(this, new Observer<List<Car>>() {
            @Override
            public void onChanged(List<Car> cars) {
                adapter.submitList(cars);
            }
        });

    }
}