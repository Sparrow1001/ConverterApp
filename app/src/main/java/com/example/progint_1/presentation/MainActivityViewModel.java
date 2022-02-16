package com.example.progint_1.presentation;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.progint_1.repository.Network.MoneyLogic;

public class MainActivityViewModel extends AndroidViewModel {

    MoneyLogic moneyLogic = new MoneyLogic();

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Float> GetCurrency(String query){
        return moneyLogic.getCurrency(query);
    }

}
