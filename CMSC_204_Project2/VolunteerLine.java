/**
 * Class manipulates Volunteer. It supports methods to interact to Volunteer object
 * 
 * @author Derek Luong
 *
 */
public class VolunteerLine implements VolunteerLineInterface {
	private final static int DEFAULT_SIZE = 10;
	
	private MyQueue<Volunteer> volunteerQueue;

	public VolunteerLine() {
		this(DEFAULT_SIZE);
	}
	
	public VolunteerLine(int size) {
		volunteerQueue = new MyQueue<Volunteer>(size);
	}
	
	@Override
	public boolean addNewVoluneer(Volunteer v) throws VolunteerException {
		if (volunteerQueue.isFull()) {
			throw new VolunteerException("Volunteer Queue is full");
		}
		return volunteerQueue.enqueue(v);
	}

	@Override
	public Volunteer volunteerTurn() throws VolunteerException {
		if (volunteerQueue.isEmpty()) {
			throw new VolunteerException("Volunteer queue is empty");
		}
		return volunteerQueue.dequeue();
	}

	@Override
	public boolean volunteerLineEmpty() {
		return volunteerQueue.isEmpty();
	}

	@Override
	public Volunteer[] toArrayVolunteer() {
		Volunteer[] volunteers = new Volunteer[volunteerQueue.size()];
		Object[] objects = volunteerQueue.toArray();
		for (int i = 0; i < objects.length; i++) {
			volunteers[i] = (Volunteer) objects[i];
		}
		return volunteers;
	}

}
