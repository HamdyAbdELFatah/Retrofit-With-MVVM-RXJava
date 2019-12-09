package com.hamdy.retrofit_mvvm.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hamdy.retrofit_mvvm.Model.Model;
import com.hamdy.retrofit_mvvm.data.PostClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyViewModel extends ViewModel {
    public MutableLiveData<List<Model>> listMutableLiveData=new MutableLiveData<>();
    PostClient p=PostClient.getINSTANCE();

    public void getPosts(){
        Call<List<Model>> call=p.getPosts();
        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                listMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {

            }
        });
    }
}
