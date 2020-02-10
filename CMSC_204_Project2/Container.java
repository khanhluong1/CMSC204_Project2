/**
 * Class manipulates DonationPackage. It supports methods to interact to DonationPackage object
 * 
 * @author Derek Luong
 *
 */
public class Container implements ContainerInterface {
	private final static int DEFAULT_SIZE = 10;
	
	private MyStack<DonationPackage> donationPackageStack;
	
	public Container() {
		this(DEFAULT_SIZE);
	}
	
	public Container(int size) {
		donationPackageStack = new MyStack<DonationPackage>(size);
	}

	@Override
	public boolean loadContainer(DonationPackage dPackage)
			throws ContainerException {
		if (donationPackageStack.isFull()) {
			throw new ContainerException("The Container is Full");
		}
		return donationPackageStack.push(dPackage);
	}

	@Override
	public DonationPackage removePackageFromContainer()
			throws ContainerException {
		if (donationPackageStack.isEmpty()) {
			throw new ContainerException("The Container is Empty");
		}
		return donationPackageStack.pop();
	}
	
	@Override
	public boolean donationPackageEmpty() {
		return donationPackageStack.isEmpty();
	}

	@Override
	public DonationPackage[] toArrayPackage() {
		DonationPackage[] donationPackages = new DonationPackage[donationPackageStack.size()];
		Object[] objects = donationPackageStack.toArray();
		for (int i = 0; i < objects.length; i++) {
			donationPackages[i] = (DonationPackage) objects[i];
		}
		return donationPackages;
	}

}
