package com.syl.sugar.model;


/**
 * Model User
 *
 * Created by shenyunlong on 3/24/16.
 */
public class User {
    public String userName;
    public String profilePictureUrl;

    @Override
    public String toString() {
        return "User{" +
                "profilePictureUrl='" + profilePictureUrl + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }

}
