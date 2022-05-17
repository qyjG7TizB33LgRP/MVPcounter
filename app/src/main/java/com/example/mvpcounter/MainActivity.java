package com.example.mvpcounter;

import android.os.Bundle;
import android.widget.Toast;

import com.example.mvpcounter.ui.Injector;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.mvpcounter.databinding.ActivityMainBinding;
public class MainActivity extends AppCompatActivity implements PresenterContracts.CounterView {
    ActivityMainBinding binding;
    private CounterPresenter counterPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        counterPresenter = Injector.getPresenter();
        counterPresenter.attachView(this);
        initClickers();
    }

    private void initClickers() {
        binding.decrementBtn.setOnClickListener(view -> counterPresenter.decrement());
        binding.incrementBtn.setOnClickListener(view -> counterPresenter.increment());


    }

    @Override
    public void updateCount(int count) {
        binding.counterTv.setTextColor(getResources().getColor(R.color.black));
        binding.counterTv.setText(String.valueOf(count));

    }

    @Override
    public void toast() {
        Toast.makeText(this,"ого ты уже дошол до 10" , Toast.LENGTH_LONG).show();
    }

    @Override
    public void setColor() {
        binding.counterTv.setTextColor(getResources().getColor(R.color.green));
    }


}



