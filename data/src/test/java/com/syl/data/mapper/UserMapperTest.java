package com.syl.data.mapper;

import com.syl.data.model.UserEntity;
import com.syl.data.model.UserEntityTest;
import com.syl.domain.model.User;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * JUnit
 * <p/>
 * Created by Shen YunLong on 2016/06/29.
 */
public class UserMapperTest {

    @Test
    public void testTransformUserEntity() {
        UserEntity entity = UserEntityTest.createFakeUserEntity();
        User user = UserMapper.transform(entity);

        assertThat(user.getLogin(), is(equalTo("sylcrq")));
        assertThat(user.getId(), is(1911334));
        assertThat(user.isSite_admin(), is(false));
        assertThat(user.getEmail(), is(nullValue()));
    }

    @Test
    public void testTransformUserEntityWhenIsNull() {
        User user = UserMapper.transform(null);
        assertThat(user, is(nullValue()));
    }
}
