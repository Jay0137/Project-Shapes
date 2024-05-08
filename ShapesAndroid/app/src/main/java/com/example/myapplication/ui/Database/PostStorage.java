package com.example.myapplication.ui.Database;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class PostStorage {

    private static final String KEY_POSTS = "key_posts";

    private SharedPreferences preferences;

    public PostStorage(Context context) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public void savePosts(List<Post> posts) {
        JSONArray jsonArray = new JSONArray();
        for (Post post : posts) {
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("id", post.getId());
                jsonObject.put("title", post.getTitle());
                jsonObject.put("content", post.getContent());
                // Add more fields if necessary
                jsonArray.put(jsonObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        preferences.edit().putString(KEY_POSTS, jsonArray.toString()).apply();
    }

    public List<Post> getPosts() {
        List<Post> posts = new ArrayList<>();
        String json = preferences.getString(KEY_POSTS, "");
        if (!json.isEmpty()) {
            try {
                JSONArray jsonArray = new JSONArray(json);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    int id = jsonObject.getInt("id");
                    String title = jsonObject.getString("title");
                    String content = jsonObject.getString("content");
                    boolean liked = jsonObject.getBoolean("liked");
                    // Retrieve more fields if necessary
                    posts.add(new Post(id, title, content, liked));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return posts;
    }
}
