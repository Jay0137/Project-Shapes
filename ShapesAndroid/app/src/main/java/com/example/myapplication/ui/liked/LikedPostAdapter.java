package com.example.myapplication.ui.liked;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.ui.post.Post;

import java.util.List;

public class LikedPostAdapter extends RecyclerView.Adapter<LikedPostAdapter.LikedPostViewHolder> {

    private List<Post> likedPosts;

    public LikedPostAdapter(List<Post> likedPosts) {
        this.likedPosts = likedPosts;
    }

    @NonNull
    @Override
    public LikedPostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_liked, parent, false);
        return new LikedPostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LikedPostViewHolder holder, int position) {
        Post post = likedPosts.get(position);
        holder.bind(post);
    }

    @Override
    public int getItemCount() {
        return likedPosts.size();
    }

    public static class LikedPostViewHolder extends RecyclerView.ViewHolder {

        private TextView titleTextView;
        private TextView contentTextView;

        public LikedPostViewHolder(@NonNull View itemView) {
            super(itemView);
        //    titleTextView = itemView.findViewById(R.id.textViewTitle);
        //    contentTextView = itemView.findViewById(R.id.textViewContent);
        }

        public void bind(Post post) {
            titleTextView.setText(post.getTitle());
            contentTextView.setText(post.getContent());
        }
    }
}
