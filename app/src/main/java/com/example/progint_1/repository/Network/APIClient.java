package com.example.progint_1.repository.Network;

import com.example.progint_1.repository.Model.MoneyAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIClient {

    @GET("pair/{firstValue}")
    Call<MoneyAPI> getConversation(@Path("firstValue") String firstValue);

}
