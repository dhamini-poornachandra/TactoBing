package com.tacto.dhamini.tacto.network.service;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.tacto.dhamini.tacto.network.interfaces.WorkManagementRestApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by plank-dhamini on 11/10/2016.
 */

public class WorkManagementRestService {

    private static WorkManagementRestService workManagementRestService = null;

    private WorkManagementRestService() {
    }

    public static synchronized WorkManagementRestService getInstance() {
        if (workManagementRestService == null) {
            workManagementRestService = new WorkManagementRestService();
        }
        return workManagementRestService;
    }

    public WorkManagementRestApi getRestApiService() {
        Retrofit retrofit = new Retrofit.Builder()
                //Todo: move the server url to config.xml (problem : ApplicationContextUtil is throwing a null pointer exception)
                //Todo: investigate the config problem
                .baseUrl("https://192.168.0.16:8080/WorkManagementSystem/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(WorkManagementRestApi.class);
    }
}
