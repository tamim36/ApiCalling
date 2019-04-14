package com.example.apicalling.Retrofit;

import com.example.apicalling.Model.Post;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface RetrofitClient {
    @GET("posts")
    Observable<List<Post>> getPostfromWeb();
}
