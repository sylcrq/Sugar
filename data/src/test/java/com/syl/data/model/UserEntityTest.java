package com.syl.data.model;

import com.syl.basecore.json.SugarJson;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * JUnit
 * <p/>
 * Created by Shen YunLong on 2016/06/25.
 */
public class UserEntityTest {

    public static final String FAKE_USER_ENTITY_JSON = "{\n" +
            "  \"login\": \"sylcrq\",\n" +
            "  \"id\": 1911334,\n" +
            "  \"avatar_url\": \"https://avatars.githubusercontent.com/u/1911334?v=3\",\n" +
            "  \"gravatar_id\": \"\",\n" +
            "  \"url\": \"https://api.github.com/users/sylcrq\",\n" +
            "  \"html_url\": \"https://github.com/sylcrq\",\n" +
            "  \"followers_url\": \"https://api.github.com/users/sylcrq/followers\",\n" +
            "  \"following_url\": \"https://api.github.com/users/sylcrq/following{/other_user}\",\n" +
            "  \"gists_url\": \"https://api.github.com/users/sylcrq/gists{/gist_id}\",\n" +
            "  \"starred_url\": \"https://api.github.com/users/sylcrq/starred{/owner}{/repo}\",\n" +
            "  \"subscriptions_url\": \"https://api.github.com/users/sylcrq/subscriptions\",\n" +
            "  \"organizations_url\": \"https://api.github.com/users/sylcrq/orgs\",\n" +
            "  \"repos_url\": \"https://api.github.com/users/sylcrq/repos\",\n" +
            "  \"events_url\": \"https://api.github.com/users/sylcrq/events{/privacy}\",\n" +
            "  \"received_events_url\": \"https://api.github.com/users/sylcrq/received_events\",\n" +
            "  \"type\": \"User\",\n" +
            "  \"site_admin\": false,\n" +
            "  \"name\": \"Shen Yunlong\",\n" +
            "  \"company\": \"iQIYI\",\n" +
            "  \"blog\": null,\n" +
            "  \"location\": \"ShangHai\",\n" +
            "  \"email\": null,\n" +
            "  \"hireable\": null,\n" +
            "  \"bio\": \"Hello World\",\n" +
            "  \"public_repos\": 36,\n" +
            "  \"public_gists\": 0,\n" +
            "  \"followers\": 16,\n" +
            "  \"following\": 59,\n" +
            "  \"created_at\": \"2012-07-01T16:17:27Z\",\n" +
            "  \"updated_at\": \"2016-06-23T02:19:37Z\"\n" +
            "}\n";

    @Test
    public void testUserEntity() {
        UserEntity entity = createFakeUserEntity();

        assertThat(entity.getLogin(), is(equalTo("sylcrq")));
        assertThat(entity.getId(), is(1911334));
        assertThat(entity.isSite_admin(), is(false));
        assertThat(entity.getEmail(), is(nullValue()));
    }

    public static UserEntity createFakeUserEntity() {
        return SugarJson.fromJson(FAKE_USER_ENTITY_JSON, UserEntity.class);
    }
}
