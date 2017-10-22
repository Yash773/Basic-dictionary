package com.example.yash.dictionary;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Yash on 30-09-2017.
 */

class APIService {
    private static API api = null;

    public static API getApi() {

        if(api==null)
        {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://od-api.oxforddictionaries.com:443/api/v1/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            api=retrofit.create(API.class);
        }
        return api;
    }
    private APIService() {
    }
}
