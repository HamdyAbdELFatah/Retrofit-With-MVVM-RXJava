package com.hamdy.retrofit_mvvm.data;

import com.hamdy.retrofit_mvvm.Model.Model;

import java.util.List;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostClient {
    private static final String BASE_URL = "http://jsonplaceholder.typicode.com/";
    private PostInterface postInterface;
    private static PostClient INSTANCE;
    public PostClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
        postInterface = retrofit.create(PostInterface.class);
    }
    public static PostClient getINSTANCE() {
        if (INSTANCE==null){
            INSTANCE = new PostClient();
        }
        return INSTANCE;
    }

    public Observable<List<Model>> getPosts(){
        return postInterface.getPosts();
    }
}
