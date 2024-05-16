package com.example.myapplication.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.Post;

import java.io.IOException;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    private List<Post> postList;
    private Context context;

    public PostAdapter(Context context, List<Post> postList) {
        this.context = context;
        this.postList = postList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post post = postList.get(position);

        // Bind data to views
        holder.tvUsername.setText(post.getUsername() + post.getUserId());
        holder.tvDescription.setText(post.getText());

        // Load image from URI
        Uri imageUri = Uri.parse(post.getImagePath());
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(context.getContentResolver(), imageUri);
            holder.ivPostImage.setImageBitmap(bitmap);
        } catch (IOException e) {
            e.printStackTrace();
            // Log error if loading image fails
            Log.e("ImageLoading", "Failed to load image from URI: " + post.getImagePath());
            // Set a default image or handle the error accordingly
            holder.ivPostImage.setImageResource(R.drawable.ic_loader);
        }

        // Set other data like likes, saved, share count if available
        // holder.tvLikes.setText(post.getLikes());
        // holder.tvSaved.setText(post.getSaved());
        // holder.tvShare.setText(post.getShare());
    }




    @Override
    public int getItemCount() {
        return postList.size();
    }

    public void setPostList(List<Post> posts) {
        postList = posts; // Update the dataset
        notifyDataSetChanged(); // Notify the adapter that the dataset has changed
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvUsername, tvDescription, tvLikes, tvSaved, tvShare;
        public ImageView ivPostImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUsername = itemView.findViewById(R.id.tvUsername);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvLikes = itemView.findViewById(R.id.tvLikes);
            tvSaved = itemView.findViewById(R.id.tvSaved);
            tvShare = itemView.findViewById(R.id.tvShare);
            ivPostImage = itemView.findViewById(R.id.ivPostImage);
        }
    }
}
