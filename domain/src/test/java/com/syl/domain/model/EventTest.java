package com.syl.domain.model;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * JUnit
 * <p>
 * Created by Shen YunLong on 2016/04/28.
 */
public class EventTest {

    private static final String FAKE_EVENTS_ID = "123456789";

    private Event events;

    @Before
    public void setUp() {
//        events = new Event();
//        events.setId(FAKE_EVENTS_ID);
    }

    @Test
    public void testEventsSetIdCase() {
        assertThat(events.getId(), is(FAKE_EVENTS_ID));
    }
}
