package com.syl.data.model;

import com.syl.basecore.json.SugarJson;
import com.syl.domain.model.CreateEvent;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * 单元测试代码
 * <p/>
 * Created by Shen YunLong on 2016/05/13.
 */
public class CreateEventEntityTest {

    private static final String FAKE_CREATE_EVENT_JSON_DATA = "{\n" +
            "    \"id\": \"4009709873\",\n" +
            "    \"type\": \"CreateEvent\",\n" +
            "    \"actor\": {\n" +
            "      \"id\": 1920564,\n" +
            "      \"login\": \"yeasy\",\n" +
            "      \"gravatar_id\": \"\",\n" +
            "      \"url\": \"https://api.github.com/users/yeasy\",\n" +
            "      \"avatar_url\": \"https://avatars.githubusercontent.com/u/1920564?\"\n" +
            "    },\n" +
            "    \"repo\": {\n" +
            "      \"id\": 58705635,\n" +
            "      \"name\": \"yeasy/cmonit\",\n" +
            "      \"url\": \"https://api.github.com/repos/yeasy/cmonit\"\n" +
            "    },\n" +
            "    \"payload\": {\n" +
            "      \"ref\": null,\n" +
            "      \"ref_type\": \"repository\",\n" +
            "      \"master_branch\": \"master\",\n" +
            "      \"description\": \"monitor for host health, container stats, etc.\",\n" +
            "      \"pusher_type\": \"user\"\n" +
            "    },\n" +
            "    \"public\": true,\n" +
            "    \"created_at\": \"2016-05-13T06:05:57Z\"\n" +
            "  }";

    @Before
    public void setUp() {
    }

    @Test
    public void testConstructHappyCase() {
        CreateEventEntity entity = SugarJson.fromJson(FAKE_CREATE_EVENT_JSON_DATA, CreateEventEntity.class);

        assertThat(entity.getId(), is(equalTo("4009709873")));
        assertThat(entity.getType(), is(equalTo("CreateEvent")));
        assertThat(entity.getActor().getId(), is(1920564));
        assertThat(entity.getActor().getLogin(), is(equalTo("yeasy")));
        assertThat(entity.getRepo().getId(), is(58705635));
        assertThat(entity.getRepo().getName(), is(equalTo("yeasy/cmonit")));
        assertThat(entity.getPayload().getRef(), is(nullValue()));
        assertThat(entity.getPayload().getRef_type(), is(equalTo("repository")));
        assertThat(entity.getOrg(), is(nullValue()));
    }

    @Test
    public void testTransformHappyCase() {
        CreateEventEntity entity = SugarJson.fromJson(FAKE_CREATE_EVENT_JSON_DATA, CreateEventEntity.class);
        CreateEvent event = new CreateEvent();
        entity.transform(entity, event);

        assertThat(event.getId(), is(equalTo("4009709873")));
        assertThat(event.getType(), is(equalTo("CreateEvent")));
        assertThat(event.getActor().getId(), is(1920564));
        assertThat(event.getActor().getLogin(), is(equalTo("yeasy")));
        assertThat(event.getRepo().getId(), is(58705635));
        assertThat(event.getRepo().getName(), is(equalTo("yeasy/cmonit")));
        assertThat(event.getPayload().getRef(), is(nullValue()));
        assertThat(event.getPayload().getRef_type(), is(equalTo("repository")));
        assertThat(event.getOrg(), is(nullValue()));
    }
}
