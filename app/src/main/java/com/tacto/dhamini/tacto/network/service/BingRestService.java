package com.tacto.dhamini.tacto.network.service;

import com.tacto.dhamini.tacto.network.interfaces.BingRestApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dhamini on 13/02/2017.
 */

public class BingRestService {

    private static BingRestService bingRestService = null;

    private BingRestService() {
    }

    public static synchronized BingRestService getInstance() {
        if (bingRestService == null) {
            bingRestService = new BingRestService();
        }
        return bingRestService;
    }

    public BingRestApi getRestApiService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://192.168.0.16:8080/WorkManagementSystem/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(BingRestApi.class);
    }
}
