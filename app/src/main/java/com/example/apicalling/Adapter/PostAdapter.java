package com.example.apicalling.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.apicalling.Model.Post;
import com.example.apicalling.R;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {

    Context context;
    List<Post> postList;

    public PostAdapter(Context context, List<Post> postList) {
        this.context = context;
        this.postList = postList;
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
        postViewHolder.txt_title.setText(String.valueOf(postList.get(i).getTitle()));
        postViewHolder.txt_content.setText(new StringBuilder(postList.get(i).getBody().substring(0,20).toString()));
        postViewHolder.txt_author.setText(String.valueOf(postList.get(i).getUserId()));
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }
}
