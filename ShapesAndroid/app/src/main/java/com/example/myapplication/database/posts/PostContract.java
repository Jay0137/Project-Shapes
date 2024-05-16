package com.example.myapplication.database.posts;

public final class PostContract {

    public static class PostEntry {
        public static final String TABLE_NAME = "posts";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_USERNAME = "username";
        public static final String COLUMN_EMAIL = "email";
        public static final String COLUMN_USER_ID = "user_id";
        public static final String COLUMN_TEXT = "text";
        public static final String COLUMN_IMAGE_PATH = "image_path";
        public static final String COLUMN_DATE = "date";
    }
}
