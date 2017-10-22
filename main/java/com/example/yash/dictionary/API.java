package com.example.yash.dictionary;

import com.example.yash.dictionary.POJOS.Antonyms.MyAntonyms;
import com.example.yash.dictionary.POJOS.Meaning;
import com.example.yash.dictionary.POJOS.Synonyms.MySynonyms;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Yash on 30-09-2017.
 */

public interface API {


    @Headers({
            "Accept: application/json",
            "app_id: feac65e3",
            "app_key: 7da8cb1bb5dd2f18af124b91f23e344e"})

    @GET("entries/en/{word_id}")
    Call<Meaning> getMeaning(@Path("word_id") String word_id);

    @Headers({
            "Accept: application/json",
            "app_id: feac65e3",
            "app_key: 7da8cb1bb5dd2f18af124b91f23e344e"})

    @GET("entries/en/{word_id}/synonyms")
    Call<MySynonyms> getSynonyms(@Path("word_id") String word_id);

    @Headers({
            "Accept: application/json",
            "app_id: feac65e3",
            "app_key: 7da8cb1bb5dd2f18af124b91f23e344e"})

    @GET("entries/en/{word_id}/antonyms")
    Call<MyAntonyms> getAntonyms(@Path("word_id") String word_id);


    /*
    @GET("group/{id}/users")
Call<List<User>> groupList(@Path("id") int groupId);
*/

}
