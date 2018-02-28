package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import iteratorfiltering.FilteringIterator;
import iteratorfiltering.IObjectTest;

public class FilteringIteratorTest {
	FilteringIterator<Integer> f;
	@Before
	public void init() {
		List<Integer> li = Arrays.asList(1,2,3);
		Iterator<Integer> it = li.iterator();
		f = new FilteringIterator<Integer>(it, new IObjectTest<Integer>() {
			@Override
			public boolean test(Object o) {
				
				if((Integer)o%2 != 0) {
					return true;
				}else {
					return false;
				}
			}
			
		});

	}
	@Test
	public void test() {
		assertTrue(f.next() == 1);
		assertTrue(f.next() == 3);
		assertEquals(null, f.next());
	}

}
