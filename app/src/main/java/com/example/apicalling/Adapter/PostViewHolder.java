package com.example.apicalling.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.TextView;

import com.example.apicalling.R;

public class PostViewHolder extends ViewHolder {

    TextView txt_title, txt_content, txt_author;

    public PostViewHolder(@NonNull View itemView) {
        super(itemView);

        txt_title = (TextView)itemView.findViewById(R.id.txt_title);
        txt_author = (TextView)itemView.findViewById(R.id.txt_author);
        txt_content = (TextView)itemView.findViewById(R.id.txt_content);

    }
}
