/**
 * 
 * Class define specific functionality of DonationManager. 
 * It supports methods to interact to Container, VolunteerLine, and RecipientLine
 * 
 * @author Derek Luong
 *
 */
public class DonationManager implements DonationManageInterface {
	private final static int DEFAULT_SIZE = 10;
	
	private Container container;
	private VolunteerLine volunteerLine;
	private RecipientLine recipientLine;
	private Volunteer deliverVolunteer;
	private DonationPackage deliverPackage;
	private Recipient recipient;
	
	
	public DonationManager() {
		this(DEFAULT_SIZE);
	}
	
	public DonationManager(int capacity) {
		container = new Container(capacity);
		volunteerLine = new VolunteerLine(capacity);
		recipientLine = new RecipientLine(capacity);
	}
	
	@Override
	public boolean ManagerLoadcontainer(DonationPackage dPackage)
			throws ContainerException {
		return container.loadContainer(dPackage);
	}

	@Override
	public boolean ManagerQueueVolunteer(Volunteer v) throws VolunteerException {
		return volunteerLine.addNewVoluneer(v);
	}

	@Override
	public boolean ManagerQueueRecipient(Recipient r) throws RecipientException {
		return recipientLine.addNewRecepient(r);
	}

	@Override
	public int donatePackage() throws VolunteerException, ContainerException,
			RecipientException {
		if (volunteerLine.volunteerLineEmpty()) {
			throw new VolunteerException("Volunteer Queue is empty");
		}
		if (recipientLine.recipientLineEmpty()) {
			throw new RecipientException("Recipient Queue is empty");
		}
		if (container.donationPackageEmpty()) {
			throw new ContainerException("Contain is empty");
		}
		deliverVolunteer = volunteerLine.volunteerTurn();
		volunteerLine.addNewVoluneer(deliverVolunteer);
		recipient = recipientLine.recipientTurn();
		deliverPackage = container.removePackageFromContainer();
		return 0;
	}
	
	public DonationPackage[] ManagerArrayPackage () {
		return container.toArrayPackage();
	}
	
	public Volunteer[] ManagerArrayVolunteer() {
		return volunteerLine.toArrayVolunteer();
	}
	
	public Recipient[] ManagerArrayRecipient() {
		return recipientLine.toArrayRecipient();
	}
	
	@Override
	public String toString() {
		return deliverVolunteer.getName() + " delivered " + deliverPackage.getDescription() + " package to " + recipient.getName();
	}

}
