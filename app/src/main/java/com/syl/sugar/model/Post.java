package com.syl.sugar.model;

/**
 * Model Post
 *
 * Created by shenyunlong on 3/24/16.
 */
public class Post {
    public User user;
    public String text;

    @Override
    public String toString() {
        return "Post{" +
                "text='" + text + '\'' +
                ", user=" + user +
                '}';
    }
}
