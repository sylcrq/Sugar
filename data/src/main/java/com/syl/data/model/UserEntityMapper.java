package com.syl.data.model;

import com.syl.domain.model.User;
import java.util.ArrayList;
import java.util.List;

/**
 * 将data层{@link UserEntity}转换为domain层{@link User}
 *
 * Created by shenyunlong on 4/7/16.
 */
public class UserEntityMapper {

    public static User transform(UserEntity userEntity) {
        User user = new User();

        user.setUserId(userEntity.getId());
        user.setCoverUrl(userEntity.getCover_url());
        user.setDescription(userEntity.getDescription());
        user.setEmail(userEntity.getEmail());
        user.setFollowers(userEntity.getFollowers());
        user.setFullName(userEntity.getFull_name());

        return user;
    }

    public static List<User> transform(List<UserEntity> userEntities) {
        List<User> userList = new ArrayList<>();

        for(UserEntity entity : userEntities) {
            userList.add(transform(entity));
        }

        return userList;
    }
}
