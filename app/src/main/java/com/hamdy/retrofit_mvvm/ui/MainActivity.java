package com.hamdy.retrofit_mvvm.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.hamdy.retrofit_mvvm.Model.Model;
import com.hamdy.retrofit_mvvm.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    MyViewModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        model = ViewModelProviders.of(this).get(MyViewModel.class);

        model.getPosts();
        RecyclerView recyclerView = findViewById(R.id.recycler);
        final PostsAdapter adapter = new PostsAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


        model.listMutableLiveData.observe(this, new Observer<List<Model>>() {
            @Override
            public void onChanged(List<Model> postModels) {
                adapter.setList(postModels);
            }
        });

    }
}
