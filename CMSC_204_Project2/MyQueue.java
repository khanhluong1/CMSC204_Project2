
public class MyQueue<T> implements QueueInterface<T> {
	private final static int DEFAULT_SIZE = 10;
	
	private int size;
	private int front;
	private int rear;
	private int numOfNodes;
	private T[] data;
	
	public MyQueue() {
		this(DEFAULT_SIZE);
	}
	
	public MyQueue(int size) {
		this.size = size;
		numOfNodes = 0;
		front = 0;
		rear = 0;
		data = (T[]) new Object[size];
	}

	@Override
	public boolean isEmpty() {
		return numOfNodes == 0;
	}

	@Override
	public boolean isFull() {
		return numOfNodes == size;
	}

	@Override
	public T dequeue() {
		if(numOfNodes == 0)
			return null;  // ** underflow error **
		else
		{  
			int frontLocation = front;
			front = (front + 1) % size; // % keeps front in bounds
			numOfNodes = numOfNodes - 1;
			return data[frontLocation];
		}
	}

	@Override
	public int size() {
		return numOfNodes;
	}

	@Override
	public boolean enqueue(T newNode) {
		if(numOfNodes == size)
			return false;  // ** overflow error **
		else
		{ 
			numOfNodes = numOfNodes + 1;
			data[rear] = newNode;
			rear = (rear + 1) % size; // % keeps rear in bounds
			return true;  // Enqueue operation successful
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toArray() {
		T[] copyData = (T[]) new Object[numOfNodes];
		int numOfCopiedNodes = 0;
		if (front + numOfNodes <= size) {
			for (int i = front; i < front+numOfNodes; i++) {
				copyData[numOfCopiedNodes] = data[i];
				numOfCopiedNodes++;
			}
		} else {
			for (int i = front; i < size; i++) {
				copyData[numOfCopiedNodes] = data[i];
				numOfCopiedNodes++;
			}
			for (int i = 0; i < front+numOfNodes-size; i++) {
				copyData[numOfCopiedNodes] = data[i];
				numOfCopiedNodes++;
			}
		}
		return copyData;
	}

}
