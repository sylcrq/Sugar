package com.syl.data.mapper;

import com.syl.data.model.event.CreateEventEntity;
import com.syl.data.model.event.CreateEventEntityTest;
import com.syl.data.model.event.ForkEventEntity;
import com.syl.data.model.event.ForkEventEntityTest;
import com.syl.data.model.event.MemberEventEntity;
import com.syl.data.model.event.MemberEventEntityTest;
import com.syl.data.model.event.WatchEventEntity;
import com.syl.data.model.event.WatchEventEntityTest;
import com.syl.domain.model.event.CreateEvent;
import com.syl.domain.model.event.ForkEvent;
import com.syl.domain.model.event.MemberEvent;
import com.syl.domain.model.event.WatchEvent;

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
public class EventMapperTest {

    @Test
    public void testTransformCreateEventEntity() {
        CreateEventEntity entity = CreateEventEntityTest.createCreateEventEntity();
        CreateEvent event = (CreateEvent) EventMapper.transform(entity);

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

    @Test
    public void testTransformForkEventEntity() {
        ForkEventEntity entity = ForkEventEntityTest.createForkEventEntity();
        ForkEvent event = (ForkEvent) EventMapper.transform(entity);

        assertThat(event.getId(), is(equalTo("3993508642")));
        assertThat(event.getType(), is(equalTo("ForkEvent")));
        assertThat(event.getActor().getId(), is(3098704));
        assertThat(event.getActor().getLogin(), is(equalTo("Piasy")));
        assertThat(event.getRepo().getId(), is(43598554));
        assertThat(event.getRepo().getName(), is(equalTo("OkBuilds/OkBuck")));
        assertThat(event.getPayload().getForkee().getId(), is(58443990));
        assertThat(event.getPayload().getForkee().getName(), is(equalTo("OkBuck")));
        assertThat(event.getPayload().getForkee().getCreated_at(), is(equalTo("2016-05-10T08:39:14Z")));
        assertThat(event.getPayload().getForkee().getOwner().getLogin(), is(equalTo("Piasy")));
        assertThat(event.getPayload().getForkee().getOwner().getUrl(), is(equalTo("https://api.github.com/users/Piasy")));
        assertThat(event.getOrg().getId(), is(19268334));
        assertThat(event.getOrg().getLogin(), is(equalTo("OkBuilds")));
    }

    @Test
    public void testTransformMemberEventEntity() {
        MemberEventEntity entity = MemberEventEntityTest.createMemberEventEntity();
        MemberEvent event = (MemberEvent) EventMapper.transform(entity);

        assertThat(event.getId(), is(equalTo("3994721133")));
        assertThat(event.getType(), is(equalTo("MemberEvent")));
        assertThat(event.getActor().getId(), is(19268334));
        assertThat(event.getActor().getLogin(), is(equalTo("OkBuilds")));
        assertThat(event.getRepo().getId(), is(52073291));
        assertThat(event.getRepo().getName(), is(equalTo("OkBuilds/buck")));
        assertThat(event.getPayload().getAction(), is(equalTo("added")));
        assertThat(event.getPayload().getMember().getLogin(), is(equalTo("Piasy")));
        assertThat(event.getPayload().getMember().getType(), is(equalTo("User")));
        assertThat(event.getOrg().getId(), is(19268334));
        assertThat(event.getOrg().getLogin(), is(equalTo("OkBuilds")));
    }

    @Test
    public void testTransformWatchEventEntity() {
        WatchEventEntity entity = WatchEventEntityTest.createWatchEventEntity();
        WatchEvent event = (WatchEvent) EventMapper.transform(entity);

        assertThat(event.getId(), is(equalTo("4009883322")));
        assertThat(event.getType(), is(equalTo("WatchEvent")));
        assertThat(event.getActor().getId(), is(1683811));
        assertThat(event.getActor().getLogin(), is(equalTo("hehonghui")));
        assertThat(event.getRepo().getName(), is(equalTo("waynell/VideoListPlayer")));
        assertThat(event.getPayload().getAction(), is(equalTo("started")));
        assertThat(event.getOrg(), is(nullValue()));
    }
}
