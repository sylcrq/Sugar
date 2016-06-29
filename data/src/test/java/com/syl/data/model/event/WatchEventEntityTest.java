package com.syl.data.model.event;

import com.syl.basecore.json.SugarJson;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * JUnit
 * <p/>
 * Created by Shen YunLong on 2016/05/13.
 */
public class WatchEventEntityTest {

    private static final String FAKE_WATCH_EVENT_JSON = "{\n" +
            "    \"id\": \"4009883322\",\n" +
            "    \"type\": \"WatchEvent\",\n" +
            "    \"actor\": {\n" +
            "      \"id\": 1683811,\n" +
            "      \"login\": \"hehonghui\",\n" +
            "      \"gravatar_id\": \"\",\n" +
            "      \"url\": \"https://api.github.com/users/hehonghui\",\n" +
            "      \"avatar_url\": \"https://avatars.githubusercontent.com/u/1683811?\"\n" +
            "    },\n" +
            "    \"repo\": {\n" +
            "      \"id\": 54194374,\n" +
            "      \"name\": \"waynell/VideoListPlayer\",\n" +
            "      \"url\": \"https://api.github.com/repos/waynell/VideoListPlayer\"\n" +
            "    },\n" +
            "    \"payload\": {\n" +
            "      \"action\": \"started\"\n" +
            "    },\n" +
            "    \"public\": true,\n" +
            "    \"created_at\": \"2016-05-13T07:15:27Z\"\n" +
            "  }";

    @Before
    public void setUp() {
    }

    @Test
    public void testConstructHappyCase() {
        WatchEventEntity entity = createWatchEventEntity();

        assertThat(entity.getId(), is(equalTo("4009883322")));
        assertThat(entity.getType(), is(equalTo("WatchEvent")));
        assertThat(entity.getActor().getId(), is(1683811));
        assertThat(entity.getActor().getLogin(), is(equalTo("hehonghui")));
        assertThat(entity.getRepo().getName(), is(equalTo("waynell/VideoListPlayer")));
        assertThat(entity.getPayload().getAction(), is(equalTo("started")));
        assertThat(entity.getOrg(), is(nullValue()));
    }

    public static WatchEventEntity createWatchEventEntity() {
        return SugarJson.fromJson(FAKE_WATCH_EVENT_JSON, WatchEventEntity.class);
    }
}
