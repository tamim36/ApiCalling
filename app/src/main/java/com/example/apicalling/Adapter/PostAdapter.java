package com.example.apicalling.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.apicalling.CommentModel.Comment;
import com.example.apicalling.Model.Post;
import com.example.apicalling.R;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {

    Context context;
    //List<Post> postList;
    List<Comment> commentList;

    public PostAdapter(Context context, List<Comment> commentList) {
        this.context = context;
        this.commentList = commentList;
    }


    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.post_layout, viewGroup, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder postViewHolder, int i) {
        postViewHolder.txt_id.setText(String.valueOf(commentList.get(i).getId()));
        postViewHolder.txt_body.setText(new StringBuilder(commentList.get(i).getBody().substring(0,20).toString()));
        postViewHolder.txt_email.setText(String.valueOf(commentList.get(i).getEmail()));
        postViewHolder.txt_post_id.setText(String.valueOf(commentList.get(i).getPostId()));
        postViewHolder.txt_name.setText(String.valueOf(commentList.get(i).getName()));
    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }
}
