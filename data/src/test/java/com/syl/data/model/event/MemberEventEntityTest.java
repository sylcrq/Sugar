package com.syl.data.model.event;

import com.syl.basecore.json.SugarJson;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * JUnit
 * <p/>
 * Created by Shen YunLong on 2016/05/13.
 */
public class MemberEventEntityTest {

    private static final String FAKE_MEMBER_EVENT_JSON = "{\n" +
            "    \"id\": \"3994721133\",\n" +
            "    \"type\": \"MemberEvent\",\n" +
            "    \"actor\": {\n" +
            "      \"id\": 19268334,\n" +
            "      \"login\": \"OkBuilds\",\n" +
            "      \"gravatar_id\": \"\",\n" +
            "      \"url\": \"https://api.github.com/users/OkBuilds\",\n" +
            "      \"avatar_url\": \"https://avatars.githubusercontent.com/u/19268334?\"\n" +
            "    },\n" +
            "    \"repo\": {\n" +
            "      \"id\": 52073291,\n" +
            "      \"name\": \"OkBuilds/buck\",\n" +
            "      \"url\": \"https://api.github.com/repos/OkBuilds/buck\"\n" +
            "    },\n" +
            "    \"payload\": {\n" +
            "      \"member\": {\n" +
            "        \"login\": \"Piasy\",\n" +
            "        \"id\": 3098704,\n" +
            "        \"avatar_url\": \"https://avatars.githubusercontent.com/u/3098704?v=3\",\n" +
            "        \"gravatar_id\": \"\",\n" +
            "        \"url\": \"https://api.github.com/users/Piasy\",\n" +
            "        \"html_url\": \"https://github.com/Piasy\",\n" +
            "        \"followers_url\": \"https://api.github.com/users/Piasy/followers\",\n" +
            "        \"following_url\": \"https://api.github.com/users/Piasy/following{/other_user}\",\n" +
            "        \"gists_url\": \"https://api.github.com/users/Piasy/gists{/gist_id}\",\n" +
            "        \"starred_url\": \"https://api.github.com/users/Piasy/starred{/owner}{/repo}\",\n" +
            "        \"subscriptions_url\": \"https://api.github.com/users/Piasy/subscriptions\",\n" +
            "        \"organizations_url\": \"https://api.github.com/users/Piasy/orgs\",\n" +
            "        \"repos_url\": \"https://api.github.com/users/Piasy/repos\",\n" +
            "        \"events_url\": \"https://api.github.com/users/Piasy/events{/privacy}\",\n" +
            "        \"received_events_url\": \"https://api.github.com/users/Piasy/received_events\",\n" +
            "        \"type\": \"User\",\n" +
            "        \"site_admin\": false\n" +
            "      },\n" +
            "      \"action\": \"added\"\n" +
            "    },\n" +
            "    \"public\": true,\n" +
            "    \"created_at\": \"2016-05-10T13:26:04Z\",\n" +
            "    \"org\": {\n" +
            "      \"id\": 19268334,\n" +
            "      \"login\": \"OkBuilds\",\n" +
            "      \"gravatar_id\": \"\",\n" +
            "      \"url\": \"https://api.github.com/orgs/OkBuilds\",\n" +
            "      \"avatar_url\": \"https://avatars.githubusercontent.com/u/19268334?\"\n" +
            "    }\n" +
            "  }";

    @Before
    public void setUp() {
    }

    @Test
    public void testConstructHappyCase() {
        MemberEventEntity entity = createMemberEventEntity();

        assertThat(entity.getId(), is(equalTo("3994721133")));
        assertThat(entity.getType(), is(equalTo("MemberEvent")));
        assertThat(entity.getActor().getId(), is(19268334));
        assertThat(entity.getActor().getLogin(), is(equalTo("OkBuilds")));
        assertThat(entity.getRepo().getId(), is(52073291));
        assertThat(entity.getRepo().getName(), is(equalTo("OkBuilds/buck")));
        assertThat(entity.getPayload().getAction(), is(equalTo("added")));
        assertThat(entity.getPayload().getMember().getLogin(), is(equalTo("Piasy")));
        assertThat(entity.getPayload().getMember().getType(), is(equalTo("User")));
        assertThat(entity.getOrg().getId(), is(19268334));
        assertThat(entity.getOrg().getLogin(), is(equalTo("OkBuilds")));
    }

    public static MemberEventEntity createMemberEventEntity() {
        return SugarJson.fromJson(FAKE_MEMBER_EVENT_JSON, MemberEventEntity.class);
    }
}
