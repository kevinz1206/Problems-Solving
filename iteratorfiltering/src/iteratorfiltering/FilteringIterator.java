package iteratorfiltering;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class FilteringIterator implements Iterator{
	private Iterator myIterator;
	private IObjectTest<?> myTest;
	private Object o;
	private boolean b = false;
	public FilteringIterator(Iterator myIterator, IObjectTest myTest) {
		super();
		this.myIterator = myIterator;
		this.myTest = myTest;
	}
	//{1,0,1,0}
	@Override
	public boolean hasNext() {
		if(b) {
			return true;
		}

		if(!myIterator.hasNext()) {
			return false;
		}else {
			Object cur = myIterator.next();
			if(myTest.test(cur)) {
				o = cur;
				b = true;
				return b;
			}else {
				return hasNext();
			}
		}
	}

	@Override
	public Object next() {
		if(!hasNext()) {
			return null;
		}
		b = false;
		return o;
	}
	public static void main(String[] args) {
		List<Integer> li = Arrays.asList(1,2,3);
		Iterator<Integer> it = li.iterator();
		FilteringIterator f = new FilteringIterator(it, new IObjectTest<Integer>() {
			@Override
			public boolean test(Object o) {
				
				if((Integer)o%2 != 0) {
					return true;
				}else {
					return false;
				}
			}
			
		});
		System.out.println("a");	
		System.out.println(f.hasNext());

		System.out.println(f.next());
		System.out.println(f.next());
		System.out.println(f.next());
		System.out.println(f.hasNext());

	}
	
}
