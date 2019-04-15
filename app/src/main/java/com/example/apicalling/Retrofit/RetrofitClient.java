package com.example.apicalling.Retrofit;

import com.example.apicalling.CommentModel.Comment;
import com.example.apicalling.Model.Post;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitClient {
    @GET("posts")
    Observable<List<Post>> getPostfromWeb();

    //Normal url
    /*@GET("posts/1/comments")
    Observable<List<Comment>> getComment();*/

    //optimize the same thing for any postID
    /*@GET("posts/{id}/comments")
    Observable<List<Comment>> getComment(@Path("id") int postid);*/

    //for comments?postId=1 type url
    @GET("comments")
    Observable<List<Comment>> getComment(@Query("postId") int postID);
}
