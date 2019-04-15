package com.example.apicalling.Retrofit;

import com.example.apicalling.CommentModel.Comment;
import com.example.apicalling.Model.Post;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

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
    /*@GET("comments")
    Observable<List<Comment>> getComment(@Query("postId") int postID);*/

    // for comments?postId=1&_sort=id&_order=desc
    /*@GET("comments")
    Observable<List<Comment>> getComment(@Query("postId") int postID, //autometically add ? question mark and after "="sign
                                         @Query("_sort") String sort,   //autometically add & sign
                                         @Query("_order") String order  //autometically add & sign
    );*/

    //for comments?postId=1&postId=2&_sort=id&_order=desc
    /*@GET("comments")
    Observable<List<Comment>> getComment(@Query("postId") int postID,
                                         @Query("postId") int postID2,
                                         @Query("_sort") String sort,
                                         @Query("_order") String order
    );*/

    //for comments?postId=1&postId=2&_sort=id&_order=desc for multiple postid like this
    /*@GET("comments")
    Observable<List<Comment>> getComment(@Query("postId") Integer[] postID,
                                         @Query("_sort") String sort,
                                         @Query("_order") String order
    );*/

    //Just put url
    @GET
    Observable<List<Comment>> getComment(@Url String url);
}
