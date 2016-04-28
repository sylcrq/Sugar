package com.syl.domain.model;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * JUnit
 * <p>
 * Created by shenyunlong on 16/4/28.
 */
public class EventsTest {

    private static final String FAKE_EVENTS_ID = "123456789";

    private Events events;

    @Before
    public void setUp() {
        events = new Events();
        events.setId(FAKE_EVENTS_ID);
    }

    @Test
    public void testEventsSetIdCase() {
        assertThat(events.getId(), is(FAKE_EVENTS_ID));
    }
}
