package com.example.apicalling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.apicalling.Adapter.PostAdapter;
import com.example.apicalling.CommentModel.Comment;
import com.example.apicalling.Model.Post;
import com.example.apicalling.Retrofit.RetrofitBuilder;
import com.example.apicalling.Retrofit.RetrofitClient;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    RetrofitClient iClient;
    RecyclerView recyclerView_posts;
    CompositeDisposable compositeDisposable = new CompositeDisposable();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init Api
        Retrofit retrofit = RetrofitBuilder.getRetrofit();
        iClient = retrofit.create(RetrofitClient.class);

        //For Recycler view and card view
        recyclerView_posts = (RecyclerView)findViewById(R.id.recycler_post);
        recyclerView_posts.setHasFixedSize(true);
        recyclerView_posts.setLayoutManager(new LinearLayoutManager(this));

        //fetchData();
        fetchComment();
    }

    private void fetchComment() {
        compositeDisposable.add(iClient.getComment(4)
            .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Comment>>() {
                               @Override
                               public void accept(List<Comment> commentList) throws Exception {
                                   displayComment(commentList);
                               }
                           }, new Consumer<Throwable>() {
                               @Override
                               public void accept(Throwable throwable) throws Exception {
                                   Toast.makeText(MainActivity.this, ""+throwable.getMessage(), Toast.LENGTH_SHORT).show();
                               }
                           }
                )
        );
    }

    private void displayComment(List<Comment> commentList) {
        PostAdapter postAdapter = new PostAdapter(this, commentList);
        recyclerView_posts.setAdapter(postAdapter);
    }

    private void fetchData() {
        compositeDisposable.add(iClient.getPostfromWeb()
            .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Post>>() {
                               @Override
                               public void accept(List<Post> posts) throws Exception {
                                   displayData(posts);
                               }
                           }, new Consumer<Throwable>() {
                               @Override
                               public void accept(Throwable throwable) throws Exception {
                                       Toast.makeText(MainActivity.this, ""+throwable.getMessage(), Toast.LENGTH_SHORT).show();
                               }
                           }
                )
        );
    }

    private void displayData(List<Post> posts) {
        //PostAdapter adapter = new PostAdapter(this, posts);
        //recyclerView_posts.setAdapter(adapter);
    }

    @Override
    protected void onStop() {
        compositeDisposable.clear();
        super.onStop();
    }
}
