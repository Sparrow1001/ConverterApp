package com.example.progint_1.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.view.View;

import com.example.progint_1.R;
import com.example.progint_1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MainActivityViewModel mainActivityViewModel = new MainActivityViewModel(getApplication());

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.spinnerGet.setSelection(117);

        binding.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String query = getResources().getStringArray(R.array.names)[binding.spinnerSend.getSelectedItemPosition()]
                        + "/" + getResources().getStringArray(R.array.names)[binding.spinnerGet.getSelectedItemPosition()];

                Float value = Float.valueOf(binding.editSend.getText().toString());

                mainActivityViewModel.GetCurrency(query).observe(MainActivity.this, new Observer<Float>() {
                    @Override
                    public void onChanged(Float aFloat) {
                        Float answer = (aFloat * value)%100;
                        String result = String.format("%.2f",answer);
                        binding.editGet.setText(result);
                    }
                });


            }
        });






    }
}