package com.example.progint_1.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.progint_1.databinding.ActivityMainBinding;
import com.example.progint_1.repository.Network.MoneyLogic;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        MoneyLogic moneyLogic = new MoneyLogic();

        ImageButton imageButton = binding.imageButton;
        EditText editText = binding.editSend;
        TextView textView = binding.Tv1;

        moneyLogic.getCoordinate("USD/RUB").observe(MainActivity.this, new Observer<Float>() {
            @Override
            public void onChanged(Float aFloat) {

            }
        });

    }
}