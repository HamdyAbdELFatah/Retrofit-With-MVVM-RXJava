package com.hamdy.retrofit_mvvm.ui;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hamdy.retrofit_mvvm.Model.Model;
import com.hamdy.retrofit_mvvm.data.PostClient;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyViewModel extends ViewModel {
    public MutableLiveData<List<Model>> listMutableLiveData = new MutableLiveData<>();
    PostClient p = PostClient.getINSTANCE();
    private static final String TAG = "MyViewModel";
    public void getPosts() {
        Observable<List<Model>> observable = p.getPosts()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread());

        Observer<List<Model>> observer = new Observer<List<Model>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
            }
            @Override
            public void onNext(@NonNull List<Model> models) {
                listMutableLiveData.setValue(models);
            }
            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "onError: "+e.getLocalizedMessage());
            }
            @Override
            public void onComplete() {
            }
        };
        observable.subscribe(observer);

    }
}
