package iteratorfiltering;

import java.util.Iterator;

public class FilteringIterator<T> implements Iterator<T>{
	private Iterator<T> myIterator;
	private IObjectTest<T> myTest;
	private T t;
	private boolean b = false;
	public FilteringIterator(Iterator<T> myIterator, IObjectTest<T> myTest) {
		super();
		this.myIterator = myIterator;
		this.myTest = myTest;
	}
	@Override
	public boolean hasNext() {
		if(b) {
			return true;
		}
		if(!myIterator.hasNext()) {
			return false;
		}else {
			T cur = myIterator.next();
			if(myTest.test(cur)) {
				t = cur;
				b = true;
				return b;
			}else {
				return hasNext();
			}
		}
	}

	@Override
	public T next() {
		if(!hasNext()) {
			return null;
		}
		b = false;
		return (T)t;
	}	
}
