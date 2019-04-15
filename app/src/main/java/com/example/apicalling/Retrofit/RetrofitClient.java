package com.example.apicalling.Retrofit;

import com.example.apicalling.CommentModel.Comment;
import com.example.apicalling.Model.Post;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitClient {
    @GET("posts")
    Observable<List<Post>> getPostfromWeb();

    @GET("posts/{id}/comments")
    Observable<List<Comment>> getComment(@Path("id") int postid);
}
