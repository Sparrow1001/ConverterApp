package com.example.progint_1.repository.Network;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.progint_1.repository.Model.MoneyAPI;

import java.security.cert.CertificateException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MoneyLogic {

    private APIClient api;

    public MoneyLogic(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://v6.exchangerate-api.com/v6/53e44e287ae7cd7c62b650f1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(APIClient.class);
    }


    public LiveData<Float> getCurrency(String query){

        MutableLiveData<Float> money = new MutableLiveData<>();

        api.getConversation(query).enqueue(new Callback<MoneyAPI>() {
            @Override
            public void onResponse(Call<MoneyAPI> call, Response<MoneyAPI> response) {
                if (response.isSuccessful() && response.body() != null) {

                    money.setValue(response.body().getConversion_rate());

                }
                Log.e("aaaaaaaaa", "ddddddddddddd" + response);
            }

            @Override
            public void onFailure(Call<MoneyAPI> call, Throwable t) {
                Log.e("ffffffffff", "ddddddddddddd"+t+call);
            }
        });

        return money;
    }

}
