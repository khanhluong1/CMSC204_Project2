
public class MyStack<T> implements StackInterface<T> {
	private final static int DEFAULT_SIZE = 10;
	
	private int size;
	private int top;
	private T[] data;
	
	public MyStack() {
		this(DEFAULT_SIZE);
	}
	
	@SuppressWarnings("unchecked")
	public MyStack(int size) {
		this.size = size;
		top = -1;
		data = (T[]) new Object[size]; // create array
	}
	
	@Override
	public boolean isEmpty() {
		return (top == -1);
	}

	@Override
	public boolean isFull() {
		return top == size - 1;
	}

	@Override
	public T pop() {
		if(top == -1)
		   return null;  // ** underflow error **
		else
		{  
			int topLocation = top;
			top = top - 1;
			return data[topLocation]; // returns a
		}
	}

	@Override
	public int size() {
		return top + 1;
	}

	@Override
	public boolean push(T newNode) {
		if(top == size - 1)
		   return false;  // ** overflow error **
		else
		{ 
			top = top + 1;
			data[top] = newNode;
			return true;  // push operation successful
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toArray() {
		T[] copyData = (T[]) new Object[this.size()];
		for (int i = top; i >= 0; i--) {
			copyData[top-i] = data[i];
		}
		return copyData;
	}

}
