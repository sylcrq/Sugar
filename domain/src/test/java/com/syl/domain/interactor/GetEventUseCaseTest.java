package com.syl.domain.interactor;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * JUnit + Mockito
 * <p>
 * Created by shenyunlong on 16/4/28.
 */
public class GetEventUseCaseTest {


    @Before
    public void setUp() {

    }

    @Test
    public void testMockitoUseDemo1() {
        List<String> mockedList = mock(List.class);

        mockedList.add("one");
        mockedList.clear();

        verify(mockedList).add("one");
        verify(mockedList).clear();
    }

    @Test
    public void testMockitoUseDemo2() {
        LinkedList<String> mockedList = mock(LinkedList.class);

        when(mockedList.get(0)).thenReturn("first");

        assertThat(mockedList.get(0), is("first"));
    }
}
