package com.syl.sugar.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by shenyunlong on 3/25/16.
 */
@Table(name = "Categories")
public class Category extends Model {

    @Column(name = "remote_id", unique = true)
    public long remoteId;
    @Column(name = "name")
    public String name;

    // Make sure to have a default constructor for every ActiveAndroid model
    public Category() {
        super();
    }
}
