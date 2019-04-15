package com.example.apicalling.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.TextView;

import com.example.apicalling.R;

public class PostViewHolder extends ViewHolder {

    TextView txt_post_id, txt_id, txt_name, txt_email, txt_body;

    public PostViewHolder(@NonNull View itemView) {
        super(itemView);

        txt_post_id = (TextView)itemView.findViewById(R.id.txt_post_id);
        txt_id = (TextView)itemView.findViewById(R.id.txt_id);
        txt_name = (TextView)itemView.findViewById(R.id.txt_name);
        txt_email = (TextView)itemView.findViewById(R.id.txt_email);
        txt_body = (TextView)itemView.findViewById(R.id.txt_body);

    }
}
