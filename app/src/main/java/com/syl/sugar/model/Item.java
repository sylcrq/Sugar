package com.syl.sugar.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by shenyunlong on 3/25/16.
 */
@Table(name = "Items")
public class Item extends Model {
    @Column(name = "remote_id", unique = true, onUniqueConflict = Column.ConflictAction.REPLACE)
    public long remoteId;
    @Column(name = "name")
    public String name;
    // This is an association to another activeandroid model
    @Column(name = "category", onUpdate = Column.ForeignKeyAction.CASCADE, onDelete = Column.ForeignKeyAction.CASCADE)
    public Category category;

    // Make sure to have a default constructor for every ActiveAndroid model
    public Item() {
        super();
    }

    public Item(Category category, String name, long remoteId) {
        super();
        this.category = category;
        this.name = name;
        this.remoteId = remoteId;
    }
}
