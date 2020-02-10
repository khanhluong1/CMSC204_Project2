/**
 * Class manipulates Recipient. It supports methods to interact to Recipient object
 * 
 * @author Derek Luong
 *
 */
public class RecipientLine implements RecipientLineInterface {
	private final static int DEFAULT_SIZE = 10;
	
	private MyQueue<Recipient> recipientQueue;
	
	public RecipientLine() {
		this(DEFAULT_SIZE);
	}
	
	public RecipientLine(int size) {
		recipientQueue = new MyQueue<Recipient>(size);
	}
	
	@Override
	public boolean addNewRecepient(Recipient rc) throws RecipientException {
		if (recipientQueue.isFull()) {
			throw new RecipientException("The Recipent Queue is Full");
		}
		return recipientQueue.enqueue(rc);
	}

	@Override
	public Recipient recipientTurn() throws RecipientException {
		if (recipientQueue.isEmpty()) {
			throw new RecipientException("The Recipient Queue is empty");
		}
		return recipientQueue.dequeue();
	}

	@Override
	public boolean recipientLineEmpty() {
		return recipientQueue.isEmpty();
	}

	@Override
	public Recipient[] toArrayRecipient() {
		Recipient[] recipients = new Recipient[recipientQueue.size()];
		Object[] objects = recipientQueue.toArray();
		for (int i = 0; i < objects.length; i++) {
			recipients[i] = (Recipient) objects[i];
		}
		return recipients;
	}

}
