package com.ly.study.thinkjava.test;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

//import junit.framework.Assert;
import org.junit.Assert;

public class MockitoTest {
	@Test
	public void createMockObject() {
		List mockdList = mock(List.class);
		Assert.assertTrue(mockdList instanceof List);
		
		ArrayList mockedArrayList = mock(ArrayList.class);
		Assert.assertTrue(mockedArrayList instanceof List);
		Assert.assertTrue(mockedArrayList instanceof ArrayList);
		
	}

	@Test
	public void createMockObject2() {
		List mockedList = mock(List.class);
		
		when(mockedList.add("one")).thenReturn(true);
		
		when(mockedList.size()).thenReturn(1);
		
		Assert.assertTrue(mockedList.add("one"));
		
		Assert.assertFalse(mockedList.add("two"));
		
		Assert.assertEquals(mockedList.size(), 1);
		
//		Iterator i = mock(Iterator.class);
//		when(i.next()).thenReturn("Hello,").thenReturn("Mockito!");
		Iterator i = mock(Iterator.class);
		when(i.next()).thenReturn("Hello,").thenReturn("Mockito!");
		
		String result = i.next() + " " + i.next();
		Assert.assertEquals("Hello, Mockito!", result);
	}
	
	@Test
	public void testVertify() {
		List mockedList = mock(List.class);
		mockedList.add("one");
		mockedList.add("two");
		mockedList.add("three times");
		mockedList.add("three times");
		mockedList.add("three times");
		
		when(mockedList.size()).thenReturn(5);
		Assert.assertEquals(mockedList.size(), 5);
		
		verify(mockedList, atLeastOnce()).add("one");
		verify(mockedList, times(1)).add("two");
		verify(mockedList, times(3)).add("three times");
		verify(mockedList, never()).isEmpty();
		
	}
	
	@Test
	public void testSpy() {
		List list = new LinkedList();
		List spy = spy(list);
		when(spy.size()).thenReturn(100);
		spy.add("one");
		spy.add("two");
		
		Assert.assertEquals(spy.get(0), "one");
		Assert.assertEquals(spy.get(1), "two");
		
		Assert.assertEquals(spy.size(), 100);
	}
	
	@Test
	public void testCaptureArgument() {
		List<String> list = Arrays.asList("1", "2");
		List mockedList = mock(List.class);
		ArgumentCaptor<List> argument = ArgumentCaptor.forClass(List.class);
		mockedList.add(list);
		verify(mockedList).addAll(argument.capture());
		
		Assert.assertEquals(2, argument.getValue().size());
		Assert.assertEquals(list, argument.getValue());
	}

}
