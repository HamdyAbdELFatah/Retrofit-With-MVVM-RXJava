package com.hamdy.retrofit_mvvm.data;

import com.hamdy.retrofit_mvvm.Model.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostInterface {

        @GET("posts")
        public Call<List<Model>> getPosts();

}
